package hcapiplantas.controller;

import hcapiplantas.exception.*;
import hcapiplantas.model.dto.PlantRequestDto;
import hcapiplantas.model.dto.PlantResponseDto;
import hcapiplantas.service.impl.PlantServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/plantas")
public class PlantController {

    @Autowired
    private PlantServiceImpl plantServiceImpl;

    @PostMapping
    public ResponseEntity<PlantResponseDto> createCategory(@Valid @RequestBody PlantRequestDto request) throws DataAlreadyExistsException, DataNotFoundException, CategoryNotFoundException, RestrictionNotFoundException, SymptomNotFoundException {
        return ResponseEntity.status(HttpStatus.CREATED).body(PlantResponseDto.fromEntityToResponse(plantServiceImpl.createPlant(request)));
    }
}
