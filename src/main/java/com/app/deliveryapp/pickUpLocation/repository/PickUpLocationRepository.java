package com.app.deliveryapp.pickUpLocation.repository;

import com.app.deliveryapp.pickUpLocation.model.PickUpLocation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PickUpLocationRepository extends JpaRepository<PickUpLocation, Long> {


}
