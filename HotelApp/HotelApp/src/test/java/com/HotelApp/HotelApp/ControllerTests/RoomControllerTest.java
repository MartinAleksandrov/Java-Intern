package com.HotelApp.HotelApp.ControllerTests;

import com.HotelApp.HotelApp.controllers.RoomController;
import com.HotelApp.HotelApp.dtos.roomDtos.NewRoomDto;
import com.HotelApp.HotelApp.services.contracts.RoomService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import java.math.BigDecimal;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(RoomController.class)
public class RoomControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private RoomService roomService;

    @Autowired
    private ObjectMapper objectMapper;

    private NewRoomDto dto;

    @BeforeEach
    public void setUp() {
        //Set data to dto
        dto = new NewRoomDto();
        dto.setName("Test Room");
        dto.setHotelName("Test Hotel");
        dto.setSize(25.0);
        dto.setFloor(2);
        dto.setPrice(BigDecimal.valueOf(100.0));
        dto.setIsBooked(false);
    }

    @Test
    @DisplayName("POST /room/createRoom -> 200 Success")
    public void whenValidInputThenReturnCreatedRoom() throws Exception {

        when(roomService.createRoom(any(NewRoomDto.class)))
                .thenReturn(dto);

        mockMvc.perform(post("/room/createRoom")
                        .contentType(APPLICATION_JSON) //Body of request will be JSON
                        .content(objectMapper.writeValueAsString(dto))) //Body of request
                .andExpect(status().isCreated())//Expected Status code
                .andExpect(jsonPath("$.name").value("Test Room"))
                .andExpect(jsonPath("$.hotelName").value("Test Hotel"))
                .andExpect(jsonPath("$.size").value(25.0))
                .andExpect(jsonPath("$.floor").value(2))
                .andExpect(jsonPath("$.price").value(BigDecimal.valueOf(100.0)))
                .andExpect(jsonPath("$.isBooked").value(false));

        verify(roomService, times(1)).createRoom(any(NewRoomDto.class));

    }

    @Test
    @DisplayName("POST /room/createRoom -> 400 Bad request")
    public void whenInvalidInputThenReturnBadRequest() throws Exception {

        //Failed @Valid annotation, missing fields
        NewRoomDto newRoomDto = new NewRoomDto();
        newRoomDto.setName("Test Room");
        //Missed fields

        mockMvc.perform(post("/room/createRoom")
                .contentType(APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(newRoomDto)))
                .andExpect(status().isBadRequest());

        //CreateRoom must never be invoked
        verify(roomService, never()).createRoom(any());
    }
}