package com.app.deliveryapp.deliveryLocation.service;

import com.app.deliveryapp.exception.GeneralException;
import com.app.deliveryapp.general.enums.ResponseCodeAndMessage;
import com.app.deliveryapp.deliveryLocation.model.DeliveryLocation;
import com.app.deliveryapp.deliveryLocation.repository.DeliveryLocationRepository;
import com.app.deliveryapp.location.repository.LocationRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@Slf4j
public class DeliveryLocationServiceImpl implements DeliveryLocationService {

    private final DeliveryLocationRepository deliveryLocationRepository;

    private final LocationRepository locationRepository;

    public DeliveryLocationServiceImpl(DeliveryLocationRepository deliveryLocationRepository, LocationRepository locationRepository) {
        this.deliveryLocationRepository = deliveryLocationRepository;
        this.locationRepository = locationRepository;
    }

    @Override
    public DeliveryLocation create(DeliveryLocation requestDTO) {

        //validate that DeliveryLocation does not exist

        DeliveryLocation deliveryLocation = new DeliveryLocation();
        deliveryLocation.setLocationId(requestDTO.getLocationId());

        return deliveryLocationRepository.save(deliveryLocation);
    }

//    @Override
//    public DeliveryLocation update(Long id, DeliveryLocation requestDTO) {
//
//        //validate that DeliveryLocation does exist
//        if(!deliveryLocationRepository.existsById(id)){
//            throw new GeneralException(ResponseCodeAndMessage.RECORD_NOT_FOUND_88.responseCode, "Delivery Location with id "+ id +" Not Found");
//        }
//
//        //validate that Location does exist
//        if(!deliveryLocationRepository.existsById(requestDTO.getLocationId())){
//            throw new GeneralException(ResponseCodeAndMessage.RECORD_NOT_FOUND_88.responseCode, "Location with id "+ id +" Not Found");
//        }
//
//        //validate that DeliveryLocation does not exist     : check that the street of that city is not the same
//
//        // get the deliveryLocation from db
//        Optional<DeliveryLocation> deliveryLocation = deliveryLocationRepository.findById(id);
//
//        deliveryLocation.get();
//
//        deliveryLocation.set(requestDTO.getLocationId());
//
//        return deliveryLocationRepository.save(deliveryLocation);
//    }

    @Override
    public void delete(Long id) {
        deliveryLocationRepository.deleteById(id);
    }

    @Override
    public List<DeliveryLocation> getAllDeliveryLocations() {

        return deliveryLocationRepository.findAll();
    }
}
