package com.scaler.bookmyshowjan23.controllers;

import com.scaler.bookmyshowjan23.dtos.BookTicketRequestDto;
import com.scaler.bookmyshowjan23.dtos.BookTicketResponseDto;
import com.scaler.bookmyshowjan23.services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class TicketController {
    private TicketService ticketService;

    @Autowired
    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    public BookTicketResponseDto bookTicket(BookTicketRequestDto request) {
        return null;
    }
}
