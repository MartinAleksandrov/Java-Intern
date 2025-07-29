package com.HotelApp.HotelApp.ServiceTests;

import com.HotelApp.HotelApp.dtos.roomDtos.NewRoomDto;
import com.HotelApp.HotelApp.dtos.roomDtos.UpdateRoomDto;
import com.HotelApp.HotelApp.entities.Hotel;
import com.HotelApp.HotelApp.entities.Room;
import com.HotelApp.HotelApp.mappers.RoomMapper;
import com.HotelApp.HotelApp.repositories.HotelRepository;
import com.HotelApp.HotelApp.repositories.RoomRepository;
import com.HotelApp.HotelApp.services.implementetion.RoomServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.math.BigDecimal;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
public class RoomServiceImplTest {

    @Mock
    private RoomRepository roomRepo;

    @Mock
    private RoomMapper roomMapper;

    @Mock
    private HotelRepository hotelRepo;

    @InjectMocks
    private RoomServiceImpl roomService;

    private NewRoomDto roomDto;
    private Room room;
    private Hotel hotel;

    @BeforeEach
    public void setUp() {

        hotel = new Hotel();
        hotel.setName("Hotel");

        roomDto = new NewRoomDto();
        roomDto.setName("Test Room");
        roomDto.setHotelName("Hotel");

        room = new Room();
        room.setId(UUID.randomUUID());
        room.setName("Test Room");
        room.setSize(5);
        room.setPrice(BigDecimal.valueOf(5.5));
    }

    @Test
    public void createRoomMustCreateNewRoomSuccessfully() {

        var expectedDto = new NewRoomDto();
        expectedDto.setName("Test Room");
        expectedDto.setHotelName("Hotel");

        var newRoom = new Room();
        newRoom.setName("Test Room");

        when(hotelRepo.findHotelByName("Hotel")).thenReturn(hotel);
        when(roomMapper.toEntity(roomDto)).thenReturn(newRoom);
        when(roomMapper.toDto(newRoom)).thenReturn(expectedDto);

        NewRoomDto result = roomService.createRoom(roomDto);


        verify(roomMapper).toEntity(roomDto);
        verify(roomMapper).toDto(newRoom);
        verify(roomRepo).save(newRoom);

        assertEquals("Test Room", result.getName());
        assertEquals("Hotel", result.getHotelName());

    }

    @Test
    public void createRoomMustThrowExceptionIfHotelNameNotFound() {

        when(hotelRepo.findHotelByName("Hotel")).thenReturn(null);

        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            roomService.createRoom(roomDto);
        });

        //Checks if exception message is equal to given one
        assertEquals("Hotel not found", exception.getMessage());

        //save method never must be invoked
        verify(roomRepo, never()).save(any());
    }

    @Test
    public void createRoomMustThrowExceptionIfRoomNameAlreadyExists() {

        // Arrange
        NewRoomDto roomDto = new NewRoomDto();
        roomDto.setHotelName("Hotel California");
        roomDto.setName("Room 101");

        // Симулираме хотел с една стая "Room 101"
        Room existingRoom = new Room();
        existingRoom.setName("Room 101");

        Hotel mockHotel = new Hotel();
        mockHotel.setName("Hotel California");
        mockHotel.setRooms(Set.of(existingRoom)); // хотел вече има такава стая

        // Mockito mock поведения
        when(hotelRepo.findHotelByName("Hotel California")).thenReturn(mockHotel);

        // Act & Assert
        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            roomService.createRoom(roomDto);
        });

        assertEquals("Hotel already contains this room", exception.getMessage());

        // Уверяваме се, че стаята не се е записала в базата
        verify(roomRepo, never()).save(any());
    }

    @Test
    public void removeRoomMustThrowExceptionIfRoomDoesNotExist() {

        Room room = new Room();
        room.setId(UUID.randomUUID());

        doNothing().when(roomRepo).deleteById(room.getId());
        doNothing().when(roomRepo).flush();
        when(roomRepo.existsById(room.getId())).thenReturn(true);

        // when / then
        RuntimeException exception = assertThrows(RuntimeException.class, () -> roomService.removeRoom(room.getId()));
        assertEquals("Something went wrong, room is not deleted", exception.getMessage());

        verify(roomRepo).deleteById(room.getId());
        verify(roomRepo).flush();
        verify(roomRepo).existsById(room.getId());
    }

    @Test
    public void updateRoomMustThrowExceptionIfRoomDoesNotExist() {

        //Arrange
        var dto = new UpdateRoomDto();
        var id = UUID.randomUUID();

        //Act
        when(roomRepo.findById(id)).thenReturn(Optional.empty());

        //Assert
        var ex = assertThrows(NoSuchElementException.class, () -> {
            roomService.updateRoom(id,dto);
        });

        assertEquals("Room not found", ex.getMessage());

        verify(roomRepo, never()).save(any());
        verify(roomMapper, never()).toUpdatedDto(any());
    }

    @Test
    public void updateRoomMustUpdateRoomSuccessfully() {

        var room1 = new Room();
        room1.setId(UUID.randomUUID());
        room1.setName("Room 1");
        room1.setSize(5);

        var updateRoomDto = new UpdateRoomDto();
        updateRoomDto.setName("Room 2");
        updateRoomDto.setSize(2);

        // Очакван DTO след update (от mapper)
        var updatedDto = new UpdateRoomDto();
        updatedDto.setName("Room 2");
        updatedDto.setSize(2);

        when(roomRepo.findById(room1.getId())).thenReturn(Optional.of(room1));
        when(roomRepo.save(room1)).thenReturn(room1); // по избор, зависи от нуждите
        when(roomMapper.toUpdatedDto(room1)).thenReturn(updatedDto);

        var result = roomService.updateRoom(room1.getId(),updateRoomDto);

        verify(roomMapper).updateEntityFromDto(updateRoomDto, room1);
        verify(roomRepo,times(1)).save(room1);
        verify(roomMapper).toUpdatedDto(room1);

        assertEquals("Room 2", result.getName());
        assertEquals(2, result.getSize());

    }
}