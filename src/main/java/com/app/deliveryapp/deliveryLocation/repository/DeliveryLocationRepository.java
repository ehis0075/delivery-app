package com.app.deliveryapp.deliveryLocation.repository;

import com.app.deliveryapp.deliveryLocation.model.DeliveryLocation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeliveryLocationRepository extends JpaRepository<DeliveryLocation, Long> {

    boolean existsById(Long id);

//    DeliveryLocation findById(Long id);


}
