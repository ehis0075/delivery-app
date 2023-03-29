package com.app.deliveryapp.location.service;

import com.app.deliveryapp.Deliverylocation.dto.CreateUpdateLocationRequestDTO;
import com.app.deliveryapp.Deliverylocation.model.Location;
import com.app.deliveryapp.Deliverylocation.repository.LocationRepository;
import com.app.deliveryapp.exception.GeneralException;
import com.app.deliveryapp.general.enums.ResponseCodeAndMessage;
import com.app.deliveryapp.util.GeneralUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Slf4j
public class LocalServiceImpl implements LocationService {

    private final LocationRepository locationRepository;

    public LocalServiceImpl(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    @Override
    public Location createLocation(CreateUpdateLocationRequestDTO requestDTO) {
        log.info("Request to create location with payload= {}", requestDTO);

        if (GeneralUtil.stringIsNullOrEmpty(requestDTO.getHouseNo())) {
            throw new GeneralException(ResponseCodeAndMessage.INCOMPLETE_PARAMETERS_91.responseCode, "house number cannot be null or empty!");
        }

        // validate that city name is not null
        if (GeneralUtil.stringIsNullOrEmpty(requestDTO.getCityName())) {
            throw new GeneralException(ResponseCodeAndMessage.INCOMPLETE_PARAMETERS_91.responseCode, "city name cannot be null or empty!");
        }

        Location location = new Location();
        location.setHouseNo(requestDTO.getHouseNo());
        location.setStreet(requestDTO.getStreetName());
        location.setCity(requestDTO.getCityName());
        location.setState(requestDTO.getStateName());
        location.setCountry(requestDTO.getCountry());
        location.setPostalCode(requestDTO.getPostalCode());

        return locationRepository.save(location);

    }

    @Override
    public Location updateLocation(Long id, CreateUpdateLocationRequestDTO requestDTO) {
        log.info("Request to create location with payload= {}", requestDTO);

        Location location = getOneLocation(id);

        if (GeneralUtil.stringIsNullOrEmpty(requestDTO.getHouseNo())) {
            throw new GeneralException(ResponseCodeAndMessage.INCOMPLETE_PARAMETERS_91.responseCode, "house number cannot be null or empty!");
        }

        // validate that city name is not null
        if (GeneralUtil.stringIsNullOrEmpty(requestDTO.getCityName())) {
            throw new GeneralException(ResponseCodeAndMessage.INCOMPLETE_PARAMETERS_91.responseCode, "city name cannot be null or empty!");
        }

        location.setHouseNo(requestDTO.getHouseNo());
        location.setStreet(requestDTO.getStreetName());
        location.setCity(requestDTO.getCityName());
        location.setState(requestDTO.getStateName());
        location.setCountry(requestDTO.getCountry());
        location.setPostalCode(requestDTO.getPostalCode());

//        location.setCreatedDate();

        return locationRepository.save(location);
    }

    @Override
    public void deleteLocation(Long id) {

        Location location = getOneLocation(id);
        locationRepository.delete(location);
    }

    @Override
    public Location getOneLocation(Long id) {
        log.info("Getting one location with Id = {}", id);

        return locationRepository.findById(id).orElseThrow(() -> new GeneralException(ResponseCodeAndMessage.RECORD_NOT_FOUND_88));
    }

    @Override
    public List<Location> getAllLocation() {
        return locationRepository.findAll();
    }
}
