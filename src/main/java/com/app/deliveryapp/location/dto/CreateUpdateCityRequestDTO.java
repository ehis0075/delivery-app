package com.app.deliveryapp.location.dto;


import lombok.Data;

import java.util.List;

@Data
public class CreateUpdateCityRequestDTO {

    private String cityName;

    private List<String> stateNames;
}
