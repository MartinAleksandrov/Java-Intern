package com.HotelApp.HotelApp.services.implementetion;

import com.HotelApp.HotelApp.dtos.staffDtos.AllHotelStaffDto;
import com.HotelApp.HotelApp.dtos.staffDtos.NewStaffDto;
import com.HotelApp.HotelApp.mappers.StaffMapper;
import com.HotelApp.HotelApp.repositories.HotelRepository;
import com.HotelApp.HotelApp.repositories.StaffRepository;
import com.HotelApp.HotelApp.services.contracts.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class StaffServiceImpl implements StaffService {

    private final StaffRepository staffRepository;
    private final HotelRepository hotelRepository;
    private final StaffMapper staffMapper;

    @Autowired
    public StaffServiceImpl(StaffRepository staffRepository,HotelRepository hotelRepository, StaffMapper staffMapper) {
        this.staffRepository = staffRepository;
        this.staffMapper = staffMapper;
        this.hotelRepository = hotelRepository;
    }

    @Override
    public NewStaffDto addStaff(NewStaffDto newStaffDto) {

        var newStaff = staffMapper.toEntity(newStaffDto);
        var hotel = hotelRepository.findHotelByName(newStaffDto.getHotelName());

        if (hotel == null) {

            throw new RuntimeException("Hotel doesn't exist");
        }

        //Check if in current hotel is working person with that combination of first + last name
        var exist = hotel.getStaffs().stream()
                .anyMatch((wholeName -> (wholeName.getFirstName() + wholeName.getLastName())
                        .equalsIgnoreCase(newStaffDto.getFirstName() + newStaff.getLastName())));

        if (exist) {
            throw new RuntimeException("Person with given name already exists");
        }

        hotel.addStaffToHotel(newStaff);
        newStaff.setHotel(hotel);
        staffRepository.save(newStaff);
        return staffMapper.toDto(newStaff);
    }


}