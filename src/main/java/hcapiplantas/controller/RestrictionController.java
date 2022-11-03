package hcapiplantas.controller;

import hcapiplantas.exception.DataAlreadyExistsException;
import hcapiplantas.exception.DataNotFoundException;
import hcapiplantas.model.dto.RestrictionRequestDto;
import hcapiplantas.model.dto.RestrictionResponseDto;
import hcapiplantas.model.dto.SymptomRequestDto;
import hcapiplantas.model.dto.SymptomResponseDto;
import hcapiplantas.model.entity.Restriction;
import hcapiplantas.model.entity.Symptom;
import hcapiplantas.service.impl.RestrictionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/restricoes")
public class RestrictionController {

    @Autowired
    private RestrictionServiceImpl service;

    @GetMapping("/{id}")
    public ResponseEntity<RestrictionResponseDto> getRestrictionById(@PathVariable Long id) throws DataNotFoundException {
        return ResponseEntity.ok(convertToDto(service.getRestrictionById(id)));
    }

    @PostMapping
    public ResponseEntity<RestrictionResponseDto> createSymptom(@Valid @RequestBody RestrictionRequestDto request) throws DataAlreadyExistsException {
        Restriction restriction = convertToEntity(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(convertToDto(service.createRestriction(restriction)));
    }

    private Restriction convertToEntity(RestrictionRequestDto request) {
        Restriction restriction = new Restriction();
        restriction.setGroupName(request.getGroupName());
        return restriction;
    }

    private RestrictionResponseDto convertToDto(Restriction restriction){
        return RestrictionResponseDto.builder()
                .id(restriction.getId().toString())
                .groupName(restriction.getGroupName())
                .build();
    }

}
