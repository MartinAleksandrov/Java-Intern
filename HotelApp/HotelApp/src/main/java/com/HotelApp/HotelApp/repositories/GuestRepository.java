package com.HotelApp.HotelApp.repositories;

import com.HotelApp.HotelApp.entities.Guest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface GuestRepository extends JpaRepository<Guest, UUID> {

    Boolean existByPhone(String phone);
}
