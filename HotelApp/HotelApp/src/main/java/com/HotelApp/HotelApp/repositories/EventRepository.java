package com.HotelApp.HotelApp.repositories;

import com.HotelApp.HotelApp.entities.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Integer> {
}
