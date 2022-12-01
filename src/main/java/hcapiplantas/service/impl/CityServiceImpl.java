package hcapiplantas.service.impl;

import hcapiplantas.exception.DataAlreadyExistsException;
import hcapiplantas.exception.DataNotFoundException;
import hcapiplantas.model.dto.CityRequestDto;
import hcapiplantas.model.entity.City;
import hcapiplantas.repository.CityRepository;
import hcapiplantas.repository.StateRepository;
import hcapiplantas.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CityServiceImpl implements CityService {

    @Autowired
    private CityRepository repository;

    @Autowired
    private StateRepository stateRepository;

    @Override
    public City createCity(CityRequestDto request) throws DataNotFoundException, DataAlreadyExistsException {
        if(repository.findByName(request.getName()).isPresent())
            throw new DataAlreadyExistsException(request.getName());

        City cityEntity = new City();
        cityEntity.setName(request.getName());
        cityEntity.setState(stateRepository.findByAcronym(request.getAcronym()).orElseThrow(() -> new DataNotFoundException(request.getAcronym())));
        return repository.save(cityEntity);
    }

    @Override
    public City getCityById(String id) throws DataNotFoundException {
        return repository.findById(Long.valueOf(id)).orElseThrow(() -> new DataNotFoundException(id));
    }

    @Override
    public List<City> getAllCities() {
        List<City> cities = new ArrayList<>();
        repository.findAll().forEach(cities::add);
        return cities;
    }

    @Override
    public void deleteCity(Long id) throws DataNotFoundException {
        repository.delete(getCityById(id.toString()));
    }
}
