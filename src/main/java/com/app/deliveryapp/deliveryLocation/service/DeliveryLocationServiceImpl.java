package com.app.deliveryapp.deliveryLocation.service;

import com.app.deliveryapp.deliveryLocation.dto.CreateUpdateDeliveryLocationRequestDTO;
import com.app.deliveryapp.deliveryLocation.model.DeliveryLocation;
import com.app.deliveryapp.deliveryLocation.repository.DeliveryLocationRepository;
import com.app.deliveryapp.exception.GeneralException;
import com.app.deliveryapp.general.enums.ResponseCodeAndMessage;
import com.app.deliveryapp.location.model.Location;
import com.app.deliveryapp.location.repository.LocationRepository;
import com.app.deliveryapp.location.service.location.LocationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;


@Service
@Slf4j
public class DeliveryLocationServiceImpl implements DeliveryLocationService {

    private final DeliveryLocationRepository deliveryLocationRepository;

    private final LocationService locationService;

    public DeliveryLocationServiceImpl(DeliveryLocationRepository deliveryLocationRepository, LocationService locationService) {
        this.deliveryLocationRepository = deliveryLocationRepository;
        this.locationService = locationService;
    }

    @Override
    public DeliveryLocation create(CreateUpdateDeliveryLocationRequestDTO requestDTO) {
        log.info("Request to create a delivery location with payload = {}", requestDTO);

        Location location = locationService.getOneLocation(requestDTO.locationId);

        DeliveryLocation deliveryLocation = new DeliveryLocation();
        deliveryLocation.setLocation(location);

        return deliveryLocationRepository.save(deliveryLocation);
    }

    @Override
    public DeliveryLocation update(Long id, CreateUpdateDeliveryLocationRequestDTO requestDTO) {
        log.info("Request to update a delivery location of id = {} with payload = {}", id, requestDTO);

        if(!deliveryLocationRepository.existsById(id)){
            throw new GeneralException(ResponseCodeAndMessage.RECORD_NOT_FOUND_88.responseCode, "Delivery Location with id "+ id +" Not Found");
        }

        Location location = locationService.getOneLocation(requestDTO.locationId);

        if(Objects.isNull(location)){
            throw new GeneralException(ResponseCodeAndMessage.RECORD_NOT_FOUND_88.responseCode, "Location with id "+ id +" Not Found");
        }

        // get the deliveryLocation from db
        DeliveryLocation deliveryLocation = getOneDeliveryLocation(id);

        deliveryLocation.setLocation(location);

        return deliveryLocationRepository.save(deliveryLocation);
    }

    @Override
    public DeliveryLocation getOneDeliveryLocation(Long id) {
        log.info("Getting delivery location with id = {}", id);

        return deliveryLocationRepository.findById(id).orElseThrow(() ->
                new GeneralException(ResponseCodeAndMessage.RECORD_NOT_FOUND_88.responseCode, "Delivery location with id "+ id + " not found"));
    }

    @Override
    public void delete(Long id) {
        log.info("Deleting delivery location with id = {}", id);

        deliveryLocationRepository.deleteById(id);
    }

    @Override
    public List<DeliveryLocation> getAllDeliveryLocations() {
        log.info("Getting delivery location list");

        return deliveryLocationRepository.findAll();
    }
}
