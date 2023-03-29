package com.app.deliveryapp.location.service;

import com.app.deliveryapp.Deliverylocation.dto.CreateUpdateLocationRequestDTO;
import com.app.deliveryapp.Deliverylocation.model.Location;

import java.util.List;

public interface LocationService {

    Location createLocation(CreateUpdateLocationRequestDTO requestDTO);
    Location updateLocation(Long id, CreateUpdateLocationRequestDTO requestDTO);
    void deleteLocation(Long id);

    Location getOneLocation(Long id);

    List<Location> getAllLocation();
}
