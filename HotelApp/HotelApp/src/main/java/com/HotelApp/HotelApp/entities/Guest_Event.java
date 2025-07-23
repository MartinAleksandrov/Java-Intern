package com.HotelApp.HotelApp.entities;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;


@Entity
@Table(name = "guest_event")
public class Guest_Event {


    @EmbeddedId
    private GuestEventId guestEventId = new GuestEventId();

    @ManyToOne
    @MapsId("guestId")
    @JoinColumn(name = "guest_id")
    private Guest guest;


    @ManyToOne
    @MapsId("eventId")
    @JoinColumn(name = "event_id")
    private Event event;


    /////////////////////
    public Guest_Event() {}

    public Guest_Event(Guest guest, Event event) {
        this.guest = guest;
        this.event = event;
        guestEventId = new GuestEventId(guest.getId(), event.getId());
    }



    /////////////////////
    //GET & SET Method
    public GuestEventId getGuestEventId() {
        return guestEventId;
    }

    public void setGuestEventId(GuestEventId guestEventId) {
        this.guestEventId = guestEventId;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public Guest getGuest() {
        return guest;
    }

    public void setGuest(Guest guest) {
        this.guest = guest;
    }
}
