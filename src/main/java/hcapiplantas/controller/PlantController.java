package hcapiplantas.controller;

import hcapiplantas.exception.*;
import hcapiplantas.model.dto.PlantRequestDto;
import hcapiplantas.model.dto.PlantResponseDto;
import hcapiplantas.model.dto.StandardResponseDto;
import hcapiplantas.model.entity.Plant;
import hcapiplantas.service.impl.PlantServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URISyntaxException;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/plantas")
public class PlantController {

    @Autowired
    private PlantServiceImpl plantServiceImpl;

    @Autowired
    private Environment env;

    private final StandardResponseDto responseDto = new StandardResponseDto();

    @PostMapping
    public ResponseEntity<StandardResponseDto> createPlant(@Valid @RequestBody PlantRequestDto request) throws DataAlreadyExistsException, CategoryNotFoundException, RestrictionNotFoundException, SymptomNotFoundException, URISyntaxException {
        Plant plant = plantServiceImpl.createPlant(request);
        responseDto.setTimestamp(LocalDateTime.now());
        responseDto.setData(List.of(PlantResponseDto.fromEntityToResponse(plant)));
        responseDto.setLink(env.getActiveProfiles(), "plantas", plant.getId().toString());
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<StandardResponseDto> deletePlant(@PathVariable String id) throws DataNotFoundException {
        plantServiceImpl.deletePlant(Long.valueOf(id));
        return ResponseEntity.noContent().build();
    }
}
