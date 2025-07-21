package com.HotelApp.HotelApp.entities;


import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

@Embeddable
public class GuestEventId implements Serializable {

                                // В базата PK на Guest е от тип "BINARY(16),
                                // JPA по подразбиране създава UUID като тип Char(36)
                                // за това указваме точния тип.
    @Column(name = "guest_id" , columnDefinition = "BINARY(16)", nullable = false,updatable = false)
    private UUID guestId;

    @Column(name = "event_id")
    private Integer eventId;


    /////////////////////
    public GuestEventId() {}

    public GuestEventId(UUID guestId, Integer eventId) {
        this.guestId = guestId;
        this.eventId = eventId;
    }



    //GET & SET Methods

    public UUID getGuestId() {
        return guestId;
    }

    public void setGuestId(UUID guestId) {
        this.guestId = guestId;
    }

    public Integer getEventId() {
        return eventId;
    }

    public void setEventId(Integer eventId) {
        this.eventId = eventId;
    }


    /////////////////////
    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(!(o instanceof GuestEventId)) return false;//Проверява инстанцията дали е от точно този тип
        GuestEventId that = (GuestEventId) o;//Каства
        return that.eventId.equals(this.eventId) && that.guestId.equals(this.guestId);// Проверява дали стойностите са еднакви
    }

    @Override
    public int hashCode() {
        return Objects.hash(guestId, eventId);
    }
}
