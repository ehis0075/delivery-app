package com.app.deliveryapp.deliveryLocation.service;

import com.app.deliveryapp.deliveryLocation.dto.CreateUpdateDeliveryLocationRequestDTO;
import com.app.deliveryapp.deliveryLocation.model.DeliveryLocation;

import java.util.List;

public interface DeliveryLocationService {

    DeliveryLocation create(CreateUpdateDeliveryLocationRequestDTO requestDTO);

    DeliveryLocation update(Long id, CreateUpdateDeliveryLocationRequestDTO requestDTO);

    DeliveryLocation getOneDeliveryLocation(Long id);


    void delete(Long id);

    List<DeliveryLocation> getAllDeliveryLocations();
}
