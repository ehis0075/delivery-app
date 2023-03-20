package com.app.deliveryapp.location.repository;

import com.app.deliveryapp.location.model.Street;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StreetRepository extends JpaRepository<Street, Long> {

    boolean existsByName(String name);

    Street findByName(String name);

}
