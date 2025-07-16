package com.HotelApp.HotelApp.mappers;

import com.HotelApp.HotelApp.dtos.staffDtos.NewStaffDto;
import com.HotelApp.HotelApp.entities.Staff;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface StaffMapper {

    @Mapping(target = "gender", source = "gender")
    NewStaffDto toDto(Staff staff);

    @Mapping(target = "gender", source = "gender")
    Staff toEntity(NewStaffDto newStaffDto);

    List<NewStaffDto> toDto(List<Staff> staffList);
}