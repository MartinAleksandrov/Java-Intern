package com.HotelApp.HotelApp.repositories;

import com.HotelApp.HotelApp.entities.GuestEventId;
import com.HotelApp.HotelApp.entities.Guest_Event;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.UUID;

public interface GuestEventRepository extends JpaRepository<Guest_Event, GuestEventId> {

    List<Guest_Event> findByGuest_Id(UUID guestId);

    // Всички гости, записани за дадено събитие
    List<Guest_Event> findByEvent_Id(int eventId);
}
