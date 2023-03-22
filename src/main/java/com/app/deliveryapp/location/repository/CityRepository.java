package com.app.deliveryapp.location.repository;

import com.app.deliveryapp.location.model.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<City, Long> {

    boolean existsByName(String name);

    City findByName(String name);

    City findByState_Name(String stateName);

    boolean existsByState_Name(String stateName);

}
