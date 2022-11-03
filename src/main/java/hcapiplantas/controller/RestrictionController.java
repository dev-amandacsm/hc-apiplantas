package hcapiplantas.controller;

import hcapiplantas.exception.DataAlreadyExistsException;
import hcapiplantas.exception.DataNotFoundException;
import hcapiplantas.model.dto.RestrictionRequestDto;
import hcapiplantas.model.dto.RestrictionResponseDto;
import hcapiplantas.model.dto.SymptomResponseDto;
import hcapiplantas.model.entity.Restriction;
import hcapiplantas.service.impl.RestrictionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/restricoes")
public class RestrictionController {

    @Autowired
    private RestrictionServiceImpl service;

    @GetMapping("/{id}")
    public ResponseEntity<RestrictionResponseDto> getRestrictionById(@PathVariable Long id) throws DataNotFoundException {
        return ResponseEntity.ok(convertToDto(service.getRestrictionById(id)));
    }

    @GetMapping
    public ResponseEntity<List<RestrictionResponseDto>> getAllRestrictions(){
        List<RestrictionResponseDto> restrictions = new ArrayList<>();
        service.getAllRestrictions().forEach(restriction -> restrictions.add(convertToDto(restriction)));
        return ResponseEntity.ok(restrictions);
    }


    @PostMapping
    public ResponseEntity<RestrictionResponseDto> createSymptom(@Valid @RequestBody RestrictionRequestDto request) throws DataAlreadyExistsException {
        Restriction restriction = convertToEntity(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(convertToDto(service.createRestriction(restriction)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<RestrictionResponseDto> updateSymptom(@PathVariable Long id, @Valid @RequestBody RestrictionRequestDto request) throws DataNotFoundException{
        return ResponseEntity.status(HttpStatus.OK).body(convertToDto(service.updateRestriction(id, convertToEntity(request))));
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
