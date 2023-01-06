package com.scaler.bookmyshowjan23.dtos;

import com.scaler.bookmyshowjan23.models.Ticket;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookTicketResponseDto {
    private ResponseStatus responseStatus;
    private Ticket ticket;
}
