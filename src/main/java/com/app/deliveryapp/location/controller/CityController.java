package com.app.deliveryapp.location.controller;

import com.app.deliveryapp.general.dto.Response;
import com.app.deliveryapp.general.enums.ResponseCodeAndMessage;
import com.app.deliveryapp.general.service.GeneralService;
import com.app.deliveryapp.location.dto.CreateUpdateCityRequestDTO;
import com.app.deliveryapp.location.model.City;
import com.app.deliveryapp.location.service.city.CityService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/citys")
public class CityController {

    private final GeneralService generalService;

    private final CityService cityService;

    public CityController(GeneralService generalService, CityService cityService) {
        this.generalService = generalService;
        this.cityService = cityService;
    }

    @PostMapping("/create")
    public Response createCity(@RequestBody CreateUpdateCityRequestDTO requestDTO) {

        City data = cityService.createCity(requestDTO);
        return generalService.prepareResponse(ResponseCodeAndMessage.SUCCESSFUL_0, data);
    }

    @GetMapping()
    public Response getAllCity() {

        List<City> data = cityService.getAllCity();
        return generalService.prepareResponse(ResponseCodeAndMessage.SUCCESSFUL_0, data);
    }

}
