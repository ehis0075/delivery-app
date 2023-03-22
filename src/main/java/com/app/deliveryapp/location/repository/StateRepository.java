package com.app.deliveryapp.location.repository;

import com.app.deliveryapp.location.model.State;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StateRepository extends JpaRepository<State, Long> {

    boolean existsByName(String name);

    State findByName(String name);

    boolean existsByCity_Name(String cityName);

}
