package com.app.deliveryapp.location.service.city;

import com.app.deliveryapp.location.dto.CreateUpdateCityRequestDTO;
import com.app.deliveryapp.location.model.City;

import java.util.List;

public interface CityService {

    City createCity(CreateUpdateCityRequestDTO requestDTO);

    List<City> getAllCity();
}
