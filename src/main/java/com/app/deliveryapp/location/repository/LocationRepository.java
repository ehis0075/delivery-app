package com.app.deliveryapp.location.repository;

import com.app.deliveryapp.location.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location, Long> {

    boolean existsById(Long id);

}
