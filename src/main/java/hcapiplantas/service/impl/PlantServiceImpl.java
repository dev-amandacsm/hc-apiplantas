package hcapiplantas.service.impl;

import hcapiplantas.exception.CategoryNotFoundException;
import hcapiplantas.exception.RestrictionNotFoundException;
import hcapiplantas.exception.SymptomNotFoundException;
import hcapiplantas.model.dto.PlantRequestDto;
import hcapiplantas.model.entity.Plant;
import hcapiplantas.model.entity.Restriction;
import hcapiplantas.model.entity.Symptom;
import hcapiplantas.repository.CategoryRepository;
import hcapiplantas.repository.PlantRepository;
import hcapiplantas.repository.RestrictionRepository;
import hcapiplantas.repository.SymptomRepository;
import hcapiplantas.service.PlantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PlantServiceImpl implements PlantService {

    @Autowired
    private PlantRepository repository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private SymptomRepository symptomRepository;

    @Autowired
    private RestrictionRepository restrictionRepository;

    @Override
    public Plant createPlant(PlantRequestDto plantRequestDto) throws CategoryNotFoundException, RestrictionNotFoundException, SymptomNotFoundException {
        Plant plantEntity = new Plant();
        plantEntity.setPopularName(plantRequestDto.getPopularName());
        plantEntity.setScientificName(plantRequestDto.getScientificName());
        plantEntity.setRecipe(plantRequestDto.getRecipe());
        plantEntity.setCategory(categoryRepository.findById(plantRequestDto.getCategoryId())
                .orElseThrow(() -> new CategoryNotFoundException(plantRequestDto.getCategoryId().toString())));

        for(Restriction r : plantRequestDto.getRestrictions()){
            Optional<Restriction> restriction = restrictionRepository.findByGroupName(r.getGroupName());
            if(restriction.isEmpty()){
                throw new RestrictionNotFoundException(r.getGroupName());
            }
            plantEntity.addRestriction(restriction.get());
        }

        for(Symptom s : plantRequestDto.getSymptoms()){
            Optional<Symptom> symptom = symptomRepository.findByName(s.getName());
            if(symptom.isEmpty()){
                throw new SymptomNotFoundException(s.getName());
            }
            plantEntity.addSymptom(symptom.get());
        }

        return repository.save(plantEntity);

    }
}
