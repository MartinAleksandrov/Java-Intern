package com.HotelApp.HotelApp.mappers;

import com.HotelApp.HotelApp.dtos.staffDtos.NewStaffDto;
import com.HotelApp.HotelApp.entities.Staff;
import org.mapstruct.Mapper;
import java.util.List;

@Mapper(componentModel = "spring")
public interface StaffMapper {

    NewStaffDto toDto(Staff staff);

    Staff toEntity(NewStaffDto newStaffDto);

    List<NewStaffDto> toDto(List<Staff> staffList);
}