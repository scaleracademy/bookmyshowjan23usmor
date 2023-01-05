package com.scaler.bookmyshowjan23.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
public class Ticket extends BaseModel {
    // T:U -> 1:1 ->  M:1
    @ManyToOne
    private User bookedBy;
    private Date bookingTime;

    @ManyToOne
    private Show show;

    @OneToMany
    private List<Payment> payments;

    @ManyToMany
    private List<ShowSeat> showSeats;
}
