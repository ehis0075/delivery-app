package com.app.deliveryapp.location.controller;

import com.app.deliveryapp.general.dto.Response;
import com.app.deliveryapp.general.enums.ResponseCodeAndMessage;
import com.app.deliveryapp.general.service.GeneralService;
import com.app.deliveryapp.location.dto.CreateUpdateLocationRequestDTO;
import com.app.deliveryapp.location.model.Location;
import com.app.deliveryapp.location.service.location.LocationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/locations")
public class LocationController {

    private final GeneralService generalService;

    private final LocationService locationService;

    public LocationController(GeneralService generalService, LocationService locationService) {
        this.generalService = generalService;
        this.locationService = locationService;
    }

    @PostMapping("/create")
    public Response createLocation(@RequestBody CreateUpdateLocationRequestDTO requestDTO) {

        Location data = locationService.createLocation(requestDTO);
        return generalService.prepareResponse(ResponseCodeAndMessage.SUCCESSFUL_0, data);
    }

    @GetMapping()
    public Response getAllLocations() {

        List<Location> data = locationService.getAllLocation();
        return generalService.prepareResponse(ResponseCodeAndMessage.SUCCESSFUL_0, data);
    }

}
