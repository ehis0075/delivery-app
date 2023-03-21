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

        Location location = locationService.getOneLocation(requestDTO.locationId);

        DeliveryLocation deliveryLocation = new DeliveryLocation();
        deliveryLocation.setLocation(location);

        return deliveryLocationRepository.save(deliveryLocation);
    }

    @Override
    public DeliveryLocation update(Long id, CreateUpdateDeliveryLocationRequestDTO requestDTO) {

        //validate that DeliveryLocation does exist
        if(!deliveryLocationRepository.existsById(id)){
            throw new GeneralException(ResponseCodeAndMessage.RECORD_NOT_FOUND_88.responseCode, "Delivery Location with id "+ id +" Not Found");
        }

        //validate that Location does exist
        if(!deliveryLocationRepository.existsById(requestDTO.getLocationId())){
            throw new GeneralException(ResponseCodeAndMessage.RECORD_NOT_FOUND_88.responseCode, "Location with id "+ id +" Not Found");
        }

        // get the location
        Location location = locationService.getOneLocation(requestDTO.locationId);

        // get the deliveryLocation from db
        DeliveryLocation deliveryLocation = getOneDeliveryLocation(id);

        deliveryLocation.setLocation(location);

        return deliveryLocationRepository.save(deliveryLocation);
    }

    @Override
    public DeliveryLocation getOneDeliveryLocation(Long id) {

        return deliveryLocationRepository.findById(id).orElseThrow(() ->
                new GeneralException(ResponseCodeAndMessage.RECORD_NOT_FOUND_88.responseCode, "Delivery location with id "+ id + " not found"));
    }

    @Override
    public void delete(Long id) {
        deliveryLocationRepository.deleteById(id);
    }

    @Override
    public List<DeliveryLocation> getAllDeliveryLocations() {

        return deliveryLocationRepository.findAll();
    }
}
