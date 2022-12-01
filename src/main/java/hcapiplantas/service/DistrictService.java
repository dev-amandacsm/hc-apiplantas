package hcapiplantas.service;

import hcapiplantas.exception.DataAlreadyExistsException;
import hcapiplantas.exception.DataNotFoundException;
import hcapiplantas.model.dto.DistrictRequestDto;
import hcapiplantas.model.entity.District;

import java.util.List;

public interface DistrictService {
    District createDistrict(DistrictRequestDto request) throws DataAlreadyExistsException, DataNotFoundException;

    District getDistrictById(String id) throws DataNotFoundException;

    List<District> getAllDistricts();

    void deleteDistrict(Long id) throws DataNotFoundException;
}
