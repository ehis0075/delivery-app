package com.app.deliveryapp.location.dto;


import lombok.Data;

@Data
public class CreateUpdateCityRequestDTO {

    private String cityName;

    public String stateName;
}
