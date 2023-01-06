package com.scaler.bookmyshowjan23.repositories;

import com.scaler.bookmyshowjan23.models.Show;
import com.scaler.bookmyshowjan23.models.ShowSeat;
import jakarta.persistence.LockModeType;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShowSeatRepository extends JpaRepository<ShowSeat, Long> {

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    List<ShowSeat> findAllByIdIn(List<Long> ids);

    @Override
    ShowSeat save(ShowSeat showSeat);
    // if the showSeat as a parameter has an ID -> update
    // else it will create

}
