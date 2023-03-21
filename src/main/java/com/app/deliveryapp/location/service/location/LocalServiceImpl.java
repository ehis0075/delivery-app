package com.app.deliveryapp.location.service.location;

import com.app.deliveryapp.exception.GeneralException;
import com.app.deliveryapp.general.enums.ResponseCodeAndMessage;
import com.app.deliveryapp.location.dto.CreateUpdateLocationRequestDTO;
import com.app.deliveryapp.location.model.City;
import com.app.deliveryapp.location.model.Location;
import com.app.deliveryapp.location.model.State;
import com.app.deliveryapp.location.model.Street;
import com.app.deliveryapp.location.repository.CityRepository;
import com.app.deliveryapp.location.repository.LocationRepository;
import com.app.deliveryapp.location.repository.StateRepository;
import com.app.deliveryapp.location.repository.StreetRepository;
import com.app.deliveryapp.util.GeneralUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Slf4j
public class LocalServiceImpl implements LocationService {

    private final LocationRepository locationRepository;

    private final StateRepository stateRepository;

    private final CityRepository cityRepository;

    private final StreetRepository streetRepository;

    public LocalServiceImpl(LocationRepository locationRepository, StateRepository stateRepository, CityRepository cityRepository, StreetRepository streetRepository) {
        this.locationRepository = locationRepository;
        this.stateRepository = stateRepository;
        this.cityRepository = cityRepository;
        this.streetRepository = streetRepository;
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

        // validate that city exist
        if (!cityRepository.existsByName(requestDTO.getCityName())) {
            throw new GeneralException(ResponseCodeAndMessage.RECORD_NOT_FOUND_88.responseCode, "city with name " + requestDTO.getCityName() + " cannot be found");
        }

        City city = cityRepository.findByName(requestDTO.getCityName());

        // validate that state name is not null
        if (GeneralUtil.stringIsNullOrEmpty(requestDTO.getStateName())) {
            throw new GeneralException(ResponseCodeAndMessage.INCOMPLETE_PARAMETERS_91.responseCode, "state name cannot be null or empty!");
        }

        // validate that state exist
        if (!cityRepository.existsByName(requestDTO.getStateName())) {
            throw new GeneralException(ResponseCodeAndMessage.RECORD_NOT_FOUND_88.responseCode, "state with name " + requestDTO.getStateName() + " cannot be found");
        }

        State state = stateRepository.findByName(requestDTO.getStateName());

        // validate that street name is not null
        if (GeneralUtil.stringIsNullOrEmpty(requestDTO.getStreetName())) {
            throw new GeneralException(ResponseCodeAndMessage.INCOMPLETE_PARAMETERS_91.responseCode, "street name cannot be null or empty!");
        }

        // validate that street exist
        if (!streetRepository.existsByName(requestDTO.getStreetName())) {
            throw new GeneralException(ResponseCodeAndMessage.RECORD_NOT_FOUND_88.responseCode, "street with name " + requestDTO.getStreetName() + " cannot be found");
        }

        Street street = streetRepository.findByName(requestDTO.getStreetName());

        Location location = new Location();
        location.setHouseNo(requestDTO.getHouseNo());
        location.setStreet(street);
        location.setCity(city);
        location.setState(state);

        return locationRepository.save(location);

    }

    @Override
    public Location getOneLocation(Long id) {

        return locationRepository.findById(id).orElseThrow(() -> new GeneralException(ResponseCodeAndMessage.RECORD_NOT_FOUND_88));
    }

    @Override
    public List<Location> getAllLocation() {
        return locationRepository.findAll();
    }
}
