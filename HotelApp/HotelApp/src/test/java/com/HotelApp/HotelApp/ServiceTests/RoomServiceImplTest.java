package com.HotelApp.HotelApp.ServiceTests;

import com.HotelApp.HotelApp.dtos.roomDtos.NewRoomDto;
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
import java.util.UUID;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;


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

    @BeforeEach
    public void setUp() {
        roomDto = new NewRoomDto();

        roomDto.setName("Test Room");
        roomDto.setHotelName("Test Hotel");

        room = new Room();
        room.setId(UUID.randomUUID());
        room.setName("Room");
        room.setSize(5);
        room.setPrice(BigDecimal.valueOf(5.5));



    }

    @Test
    public void createRoom_MustThrow_Exception_If_HotelName_NotFound() {

        when(hotelRepo.findHotelByName(roomDto.getHotelName())).thenReturn(null);

        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            roomService.createRoom(roomDto);
        });

        //Checks if exception message is equal to given one
        assertEquals("Hotel not found", exception.getMessage());

        //save method never must be invoked
        verify(roomRepo, never()).save(any());


    }

    @Test
    public void removeRoom_Must_Throw_Exception_If_room_does_not_exist() {

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
}