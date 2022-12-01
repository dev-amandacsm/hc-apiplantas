package hcapiplantas.service.impl;

import hcapiplantas.exception.DataAlreadyExistsException;
import hcapiplantas.exception.DataNotFoundException;
import hcapiplantas.model.dto.DistrictRequestDto;
import hcapiplantas.model.entity.District;
import hcapiplantas.repository.CityRepository;
import hcapiplantas.repository.DistrictRepository;
import hcapiplantas.service.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DistrictServiceImpl implements DistrictService {

    @Autowired
    private DistrictRepository repository;

    @Autowired
    private CityRepository cityRepository;

    @Override
    public District createDistrict(DistrictRequestDto request) throws DataAlreadyExistsException, DataNotFoundException {
        if(repository.findByName(request.getName()).isPresent()){
            throw new DataAlreadyExistsException(request.getName());
        }
        District district = new District();
        district.setName(request.getName());
        district.setCity(cityRepository.findByName(request.getCityName()).orElseThrow(() ->
                new DataNotFoundException(request.getCityName())));

        return repository.save(district);
    }

    @Override
    public District getDistrictById(String id) throws DataNotFoundException {
        return repository.findById(Long.valueOf(id)).orElseThrow(() -> new DataNotFoundException(id));
    }

    @Override
    public List<District> getAllDistricts() {
        List<District> districts = new ArrayList<>();
        repository.findAll().forEach(districts::add);
        return districts;
    }

    @Override
    public void deleteDistrict(Long id) throws DataNotFoundException {
        repository.delete(getDistrictById(id.toString()));
    }

}
