package com.scaler.bookmyshowjan23.services;

import com.scaler.bookmyshowjan23.controllers.TicketController;
import com.scaler.bookmyshowjan23.exceptions.ShowSeatNotAvailableException;
import com.scaler.bookmyshowjan23.models.*;
import com.scaler.bookmyshowjan23.repositories.ShowRepository;
import com.scaler.bookmyshowjan23.repositories.ShowSeatRepository;
import com.scaler.bookmyshowjan23.repositories.TicketRepository;
import com.scaler.bookmyshowjan23.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class TicketService {
    private ShowSeatRepository showSeatRepository;
    private ShowRepository showRepository;
    private UserRepository userRepository;
    private TicketRepository ticketRepository;

    @Autowired
    public TicketService(ShowSeatRepository showSeatRepository, ShowRepository showRepository, UserRepository userRepository, TicketRepository ticketRepository) {
        this.userRepository = userRepository;
        this.ticketRepository = ticketRepository;
        this.showSeatRepository = showSeatRepository;
        this.showRepository = showRepository;
    }

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public Ticket bookTicket(Long userId,
                             List<Long> showSeatIds,
                             Long showId) throws ShowSeatNotAvailableException {
        // Get the show seat for the given show seat ids
            List<ShowSeat> showSeats = showSeatRepository.findAllByIdIn(showSeatIds);

        // check if all the show seat are available
        // if show seat are not available: throw exception
            for (ShowSeat showSeat: showSeats) {
                if (!showSeat.getSeatStatus().equals(SeatStatus.AVAILABLE)) {
                    throw new ShowSeatNotAvailableException(
                            "ShowSeat " + showSeat.getSeat().getName() + " unavailable for booking."
                    );
                }
            }

//                if (showSeat.getSeatStatus().equals(SeatStatus.AVAILABLE) ||
//                        (showSeat.getSeatStatus().equals(SeatStatus.LOCKED) &&
//                                Duration.between(Instant.(showSeat.getLockedAt()), Instant.now())))
//            }

        // else, lock all the seats => set status of all seats as locked in DB
        List<ShowSeat> updatedShowSeats = new ArrayList<>();

        for (ShowSeat showSeat: showSeats) {
            showSeat.setSeatStatus(SeatStatus.LOCKED);
            updatedShowSeats.add(showSeatRepository.save(showSeat));
        }

        Optional<User> bookedBy = userRepository.findById(userId);

//        if (bookedBy.isEmpty()) {
//            throw new InvalidUserException();
//        }
        // create ticket object, save it in DB and return
        Ticket ticket = new Ticket();
        ticket.setBookingTime(new Date());
        ticket.setShow(showRepository.findById(showId).get());
        ticket.setShowSeats(updatedShowSeats);
        ticket.setBookedBy(bookedBy.get());

        return ticketRepository.save(ticket);
    }
}
