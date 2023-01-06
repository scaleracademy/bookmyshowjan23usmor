package com.scaler.bookmyshowjan23.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class BookTicketRequestDto {
    private List<Long> showSeatIds;
    private Long showId;
    private Long userId;
}

// showSeatId -> Show