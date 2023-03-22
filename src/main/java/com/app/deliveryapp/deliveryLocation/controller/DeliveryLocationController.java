package com.app.deliveryapp.deliveryLocation.controller;

import com.app.deliveryapp.deliveryLocation.dto.CreateUpdateDeliveryLocationRequestDTO;
import com.app.deliveryapp.deliveryLocation.model.DeliveryLocation;
import com.app.deliveryapp.deliveryLocation.service.DeliveryLocationService;
import com.app.deliveryapp.general.dto.Response;
import com.app.deliveryapp.general.enums.ResponseCodeAndMessage;
import com.app.deliveryapp.general.service.GeneralService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/deliveryLocations")
public class DeliveryLocationController {

    private final GeneralService generalService;

    private final DeliveryLocationService deliveryLocationService;

    public DeliveryLocationController(GeneralService generalService, DeliveryLocationService deliveryLocationService) {
        this.generalService = generalService;
        this.deliveryLocationService = deliveryLocationService;
    }

    @PostMapping("/create")
    public Response createDeliveryLocation(@RequestBody CreateUpdateDeliveryLocationRequestDTO requestDTO) {

        DeliveryLocation data = deliveryLocationService.create(requestDTO);
        return generalService.prepareResponse(ResponseCodeAndMessage.SUCCESSFUL_0, data);
    }

    @PutMapping ("/update/{id}")
    public Response updateDeliveryLocation(@PathVariable Long id, @RequestBody CreateUpdateDeliveryLocationRequestDTO requestDTO) {

        DeliveryLocation data = deliveryLocationService.update(id, requestDTO);
        return generalService.prepareResponse(ResponseCodeAndMessage.SUCCESSFUL_0, data);
    }

    @DeleteMapping("/delete/{id}")
    public Response updateDeliveryLocation(@PathVariable Long id) {

        deliveryLocationService.delete(id);
        return generalService.prepareResponse(ResponseCodeAndMessage.SUCCESSFUL_0, "");
    }

    @GetMapping()
    public Response getAllDeliveryLocation() {

        List<DeliveryLocation> data = deliveryLocationService.getAllDeliveryLocations();
        return generalService.prepareResponse(ResponseCodeAndMessage.SUCCESSFUL_0, data);
    }

}
