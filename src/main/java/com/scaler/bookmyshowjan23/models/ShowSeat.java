package com.scaler.bookmyshowjan23.models;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class ShowSeat  extends BaseModel {
    // SS:S 1:1   M:1 -> M:1
    @ManyToOne
    private Show show;

    // SS:S
    @ManyToOne
    private Seat seat;
    @Enumerated(EnumType.ORDINAL)
    private SeatStatus seatStatus;
}
