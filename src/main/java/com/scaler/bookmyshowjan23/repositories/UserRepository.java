package com.scaler.bookmyshowjan23.repositories;

import com.scaler.bookmyshowjan23.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Override
    Optional<User> findById(Long aLong);
}

// one way to hadle no rows -> null
// but checking against null is not enforced by compiler
