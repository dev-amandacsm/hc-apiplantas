package hcapiplantas.service;

import hcapiplantas.exception.CategoryNotFoundException;
import hcapiplantas.exception.RestrictionNotFoundException;
import hcapiplantas.exception.SymptomNotFoundException;
import hcapiplantas.model.dto.PlantRequestDto;
import hcapiplantas.model.dto.PlantResponseDto;
import hcapiplantas.model.entity.Plant;

public interface PlantService {
    Plant createPlant(PlantRequestDto plantRequestDto) throws CategoryNotFoundException, SymptomNotFoundException, RestrictionNotFoundException;
}
