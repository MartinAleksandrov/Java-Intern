package com.HotelApp.HotelApp.repositories;

import com.HotelApp.HotelApp.entities.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RoomRepository extends JpaRepository<Room, UUID> {

    Boolean existsByName(String name);
}
