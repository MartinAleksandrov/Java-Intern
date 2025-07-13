package com.HotelApp.HotelApp.repositories;

import com.HotelApp.HotelApp.entities.Guest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface GuestRepository extends JpaRepository<Guest, UUID> {

    @Query("SELECT COUNT(g) > 0 FROM Guest g WHERE g.phone = :phone")
    Boolean phoneExists(@Param("phone") String phone);
}
