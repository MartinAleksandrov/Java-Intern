package com.HotelApp.HotelApp.repositories;


import com.HotelApp.HotelApp.entities.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, UUID> {
    void deleteByName(String name);
    Boolean existsByName(String name);
    Object findByName(String name);
    Hotel findHotelByName(String hotelName);

}
