package com.app.deliveryapp.location.service.location;

import com.app.deliveryapp.location.dto.CreateUpdateLocationRequestDTO;
import com.app.deliveryapp.location.model.Location;

import java.util.List;

public interface LocationService {

    Location createLocation(CreateUpdateLocationRequestDTO requestDTO);

    List<Location> getAllLocation();
}
