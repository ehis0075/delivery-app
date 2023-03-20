package com.app.deliveryapp.location.service.street;

import com.app.deliveryapp.location.dto.CreateUpdateLocationRequestDTO;
import com.app.deliveryapp.location.dto.CreateUpdateStreetRequestDTO;
import com.app.deliveryapp.location.model.Location;
import com.app.deliveryapp.location.model.Street;

import java.util.List;

public interface StreetService {

    Street createStreet(CreateUpdateStreetRequestDTO requestDTO);

    List<Street> getAllStreet();
}
