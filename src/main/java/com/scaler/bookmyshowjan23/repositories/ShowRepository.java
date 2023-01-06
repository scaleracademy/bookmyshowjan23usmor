package com.scaler.bookmyshowjan23.repositories;

import com.scaler.bookmyshowjan23.models.Show;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ShowRepository
        extends JpaRepository<Show, Long> {
// Map<Id- Long, Show>


    @Override
    Optional<Show> findById(Long aLong);
}

// Spring Data JPA -> Hibernate ORM
// ORM -> Object Relational Mapping
