package com.HotelApp.HotelApp.JPQL;

import com.HotelApp.HotelApp.dtos.roomDtos.UpdateRoomDto;
import com.HotelApp.HotelApp.entities.Room;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class RoomServiceManual {


    public List<UpdateRoomDto> getAllRoomsByHotelId(UUID hotelId) {

        EntityManager em = JpaUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();

        List<UpdateRoomDto> allRoomsDto;

        try{
            tx.begin();

            String jpql = "Select r from Room r WHERE r.hotel.id = :hotelId";
            TypedQuery<Room> query = em.createQuery(jpql, Room.class);//Типизирана заявка

            query.setParameter("hotelId", hotelId);//Parameter binding, this save us from SQL injection

            List<Room> rooms = query.getResultList(); //All rooms from given hotelId

            allRoomsDto = rooms
                    .stream()
                    .map(this::mapToDto)
                    .collect(Collectors.toList());

            tx.commit();
        }
        catch (Exception e){
            if (tx.isActive()){
                tx.rollback();//Roll back if transaction is not closed
            }
            throw new RuntimeException("Transaction failed", e);
        }
        finally {
            em.close();//Manual closing recurses
        }

        return allRoomsDto;
    }

    //Manual mapping from Entity to DTO
    private UpdateRoomDto mapToDto(Room room) {
        var dto = new UpdateRoomDto();

        dto.setRoomId(room.getId().toString());
        dto.setName(room.getName());
        dto.setSize(room.getSize());
        dto.setFloor(room.getFloor());
        dto.setPrice(room.getPrice());

        return dto;
    }
}