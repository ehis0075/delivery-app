package com.app.deliveryapp.location.dto;


import lombok.Data;

@Data
public class CreateUpdateStreetRequestDTO {

    private String streetName;

    private String cityName;

    public String stateName;
}
