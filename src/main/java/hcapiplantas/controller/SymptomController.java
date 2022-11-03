package hcapiplantas.controller;

import hcapiplantas.exception.DataAlreadyExistsException;
import hcapiplantas.model.dto.SymptomRequestDto;
import hcapiplantas.model.dto.SymptomResponseDto;
import hcapiplantas.model.entity.Symptom;
import hcapiplantas.service.impl.SymptomServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/sintomas")
public class SymptomController {

    @Autowired
    private SymptomServiceImpl service;

    @PostMapping
    public ResponseEntity<SymptomResponseDto> createSymptom(@Valid @RequestBody SymptomRequestDto request) throws DataAlreadyExistsException {
        Symptom symptom = convertToEntity(request);
        SymptomResponseDto response = convertToDto(service.createSymptom(symptom));
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
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
