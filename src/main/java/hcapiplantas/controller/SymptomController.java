package hcapiplantas.controller;

import hcapiplantas.exception.DataAlreadyExistsException;
import hcapiplantas.exception.DataNotFoundException;
import hcapiplantas.model.dto.SymptomRequestDto;
import hcapiplantas.model.dto.SymptomResponseDto;
import hcapiplantas.model.entity.Symptom;
import hcapiplantas.service.impl.SymptomServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/sintomas")
public class SymptomController {

    @Autowired
    private SymptomServiceImpl service;

    @GetMapping("/{id}")
    public ResponseEntity<SymptomResponseDto> getSymptomById(@PathVariable Long id) throws DataNotFoundException {
        return ResponseEntity.ok(convertToDto(service.getSymptomById(id)));
    }

    @GetMapping
    public ResponseEntity<List<SymptomResponseDto>> getAllSymptoms(){
        List<SymptomResponseDto> symptoms = new ArrayList<>();
        service.getAllSymptoms().forEach(symptom -> symptoms.add(convertToDto(symptom)));
        return ResponseEntity.ok(symptoms);
    }

    @PostMapping
    public ResponseEntity<SymptomResponseDto> createSymptom(@Valid @RequestBody SymptomRequestDto request) throws DataAlreadyExistsException {
        Symptom symptom = convertToEntity(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(convertToDto(service.createSymptom(symptom)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<SymptomResponseDto> updateSymptom(@PathVariable Long id, @Valid @RequestBody SymptomRequestDto request) throws DataNotFoundException {
        Symptom symptom = convertToEntity(request);
        return ResponseEntity.ok(convertToDto(service.updateCategory(id, symptom)));
    }

    private Symptom convertToEntity(SymptomRequestDto request) {
        Symptom symptom = new Symptom();
        symptom.setName(request.getName());
        return symptom;
    }

    private SymptomResponseDto convertToDto(Symptom symptom){
        return SymptomResponseDto.builder()
                .id(symptom.getId().toString())
                .name(symptom.getName())
                .build();
    }

}
