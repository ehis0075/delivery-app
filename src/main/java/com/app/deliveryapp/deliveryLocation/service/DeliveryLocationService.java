package com.app.deliveryapp.deliveryLocation.service;

import com.app.deliveryapp.deliveryLocation.model.DeliveryLocation;

import java.util.List;

public interface DeliveryLocationService {

    DeliveryLocation create(DeliveryLocation requestDTO);

//    DeliveryLocation update(Long id, DeliveryLocation requestDTO);

    void delete(Long id);

    List<DeliveryLocation> getAllDeliveryLocations();
}
