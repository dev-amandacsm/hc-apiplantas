package hcapiplantas.controller;

import hcapiplantas.exception.*;
import hcapiplantas.model.dto.PlantRequestDto;
import hcapiplantas.model.dto.PlantResponseDto;
import hcapiplantas.model.entity.Plant;
import hcapiplantas.service.impl.PlantServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/plantas")
public class PlantController {

    @Autowired
    private PlantServiceImpl plantServiceImpl;

    @PostMapping
    public ResponseEntity<PlantResponseDto> createPlant(@Valid @RequestBody PlantRequestDto request) throws DataAlreadyExistsException, CategoryNotFoundException, RestrictionNotFoundException, SymptomNotFoundException, URISyntaxException, MalformedURLException {
        Plant plant = plantServiceImpl.createPlant(request);
        PlantResponseDto plantResponseDto = PlantResponseDto.fromEntityToResponse(plant);
        plantResponseDto.setLink(new URI(ServletUriComponentsBuilder.fromCurrentRequestUri().build() + "/" + plant.getId()));
        return ResponseEntity.status(HttpStatus.CREATED).body(plantResponseDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<PlantResponseDto> deletePlant(@PathVariable String id) throws DataNotFoundException {
        plantServiceImpl.deletePlant(Long.valueOf(id));
        return ResponseEntity.noContent().build();
    }

    @GetMapping("{id}")
    public ResponseEntity<PlantResponseDto> getPlantById(@PathVariable String id) throws DataNotFoundException, URISyntaxException, MalformedURLException {
        Plant plant = plantServiceImpl.getPlantById(Long.valueOf(id));
        return ResponseEntity.ok(PlantResponseDto.fromEntityToResponse(plant));
    }

    @GetMapping
    public ResponseEntity<List<PlantResponseDto>> getPlantBySymptom(@Nullable @RequestParam String symptom, @Nullable @RequestParam String category) throws URISyntaxException, DataNotFoundException, SymptomNotFoundException, MalformedURLException, CategoryNotFoundException {
        List<PlantResponseDto> plantResponseDtoList = new ArrayList<>();
        List<Plant> plants;

        if(ObjectUtils.isEmpty(category) && ObjectUtils.isEmpty(symptom))
            plants = plantServiceImpl.getAll();
        else if(ObjectUtils.isEmpty(symptom))
            plants = plantServiceImpl.getPlantByCategory(category);
        else
            plants = plantServiceImpl.getPlantBySymptom(symptom);

        for (Plant plant : plants) {
            PlantResponseDto plantResponseDto = PlantResponseDto.fromEntityToResponse(plant);
            plantResponseDto.setLink(new URI(ServletUriComponentsBuilder.fromCurrentRequestUri().build() + "/" + plant.getId()));
            plantResponseDtoList.add(plantResponseDto);
        }

        return ResponseEntity.ok(plantResponseDtoList);
    }

}
