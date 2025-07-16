package com.HotelApp.HotelApp.repositories;

import com.HotelApp.HotelApp.entities.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface StaffRepository extends JpaRepository<Staff, UUID> {
    boolean existsByFirstNameAndLastName(String firstName, String lastName);
}
