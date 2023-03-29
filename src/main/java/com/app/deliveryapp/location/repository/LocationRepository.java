package com.app.deliveryapp.Deliverylocation.repository;

import com.app.deliveryapp.Deliverylocation.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location, Long> {
}
