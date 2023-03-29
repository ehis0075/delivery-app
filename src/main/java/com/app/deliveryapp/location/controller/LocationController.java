package com.app.deliveryapp.location.controller;

import com.app.deliveryapp.Deliverylocation.dto.CreateUpdateLocationRequestDTO;
import com.app.deliveryapp.Deliverylocation.model.Location;
import com.app.deliveryapp.general.dto.Response;
import com.app.deliveryapp.general.enums.ResponseCodeAndMessage;
import com.app.deliveryapp.general.service.GeneralService;
import com.app.deliveryapp.location.service.LocationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/deliveryLocations")
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

    @PutMapping("/update/{id}")
    public Response updateLocation(@PathVariable Long id, @RequestBody CreateUpdateLocationRequestDTO requestDTO) {

        Location data = locationService.updateLocation(id, requestDTO);
        return generalService.prepareResponse(ResponseCodeAndMessage.SUCCESSFUL_0, data);
    }

    @DeleteMapping("/delete/{id}")
    public Response deleteLocation(@PathVariable Long id) {

        locationService.deleteLocation(id);
        return generalService.prepareResponse(ResponseCodeAndMessage.SUCCESSFUL_0, "");
    }

    @GetMapping()
    public Response getAllLocations() {

        List<Location> data = locationService.getAllLocation();
        return generalService.prepareResponse(ResponseCodeAndMessage.SUCCESSFUL_0, data);
    }

}
