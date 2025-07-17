package com.HotelApp.HotelApp.services.implementetion;

import com.HotelApp.HotelApp.dtos.bookingDtos.NewBookingDto;
import com.HotelApp.HotelApp.entities.Booking;
import com.HotelApp.HotelApp.entities.Guest;
import com.HotelApp.HotelApp.entities.Hotel;
import com.HotelApp.HotelApp.entities.Room;
import com.HotelApp.HotelApp.mappers.BookingMapper;
import com.HotelApp.HotelApp.repositories.BookingRepository;
import com.HotelApp.HotelApp.repositories.GuestRepository;
import com.HotelApp.HotelApp.repositories.HotelRepository;
import com.HotelApp.HotelApp.repositories.RoomRepository;
import com.HotelApp.HotelApp.services.contracts.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class BookingServiceImpl implements BookingService {

    private final BookingRepository bookingRepository;
    private final RoomRepository roomRepository;
    private final GuestRepository guestRepository;
    private final HotelRepository hotelRepository;
    private final BookingMapper bookingMapper;

    @Autowired
    public BookingServiceImpl(BookingRepository bookingRepository, BookingMapper bookingMapper,
                              HotelRepository hotelRepository, RoomRepository roomRepository,
                              GuestRepository guestRepository) {
        this.bookingRepository = bookingRepository;
        this.bookingMapper = bookingMapper;
        this.hotelRepository = hotelRepository;
        this.roomRepository = roomRepository;
        this.guestRepository = guestRepository;
    }

    @Override
    public NewBookingDto addBooking(NewBookingDto dto) {

        Hotel hotel = hotelRepository.findHotelByName(dto.getHotelName());
        Room room = roomRepository.findRoomByName(dto.getRoomName());
        Guest guest = guestRepository.findGuestsByFirstNameAndLastName(dto.getGuestFirstName(), dto.getGuestLastName());

        if (isBookingValid(hotel, room, guest, dto)) {
            Booking booking = bookingMapper.toEntity(dto);
            booking.setHotel(hotel);
            guest.setHotel(hotel);
            booking.setRoom(room);
            booking.setGuest(guest);

            room.setIsBooked(true);
            bookingRepository.save(booking);

            return bookingMapper.toDto(booking);
        }

        throw new RuntimeException("Invalid booking request");
    }

    private boolean isBookingValid(Hotel hotel, Room room, Guest guest, NewBookingDto dto) {
        return hotel != null
                && room != null
                && guest != null
                && !room.getIsBooked()
                && doesHotelContainsRoom(hotel, dto.getRoomName())
                && !doesGuestHaveBooking(hotel, guest.getId());
    }

    private boolean doesHotelContainsRoom(Hotel hotel, String roomName) {

        return hotel.getRooms()
                .stream()
                .anyMatch(room -> room.getName().equals(roomName));
    }

    private boolean doesGuestHaveBooking(Hotel hotel, UUID guestId) {

        return hotel.getBookings()
                .stream()
                .anyMatch(booking -> booking.getGuest().getId().equals(guestId));
    }
}