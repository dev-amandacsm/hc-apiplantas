package hcapiplantas.controller;

import hcapiplantas.exception.DataAlreadyExistsException;
import hcapiplantas.exception.DataNotFoundException;
import hcapiplantas.model.dto.PlantResponseDto;
import hcapiplantas.model.dto.StateRequestDto;
import hcapiplantas.model.dto.StateResponseDto;
import hcapiplantas.model.entity.State;
import hcapiplantas.service.impl.StateServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;

@RestController
@RequestMapping("/estados")
public class StateController {

    @Autowired
    private StateServiceImpl stateService;

    @PostMapping
    public ResponseEntity<StateResponseDto> createState(@Valid @RequestBody StateRequestDto request) throws DataAlreadyExistsException, URISyntaxException {
        State state = stateService.createState(request);
        StateResponseDto stateResponseDto = StateResponseDto.fromEntityToResponse(state);
        stateResponseDto.setLink(new URI(ServletUriComponentsBuilder.fromCurrentRequestUri().build() + "/" + state.getAcronym()));
        return ResponseEntity.created(stateResponseDto.getLink()).body(stateResponseDto);
    }

    @GetMapping("/{acronym}")
    public ResponseEntity<StateResponseDto> getStateById(@PathVariable String acronym) throws DataNotFoundException {
        State state = stateService.getStateById(acronym);
        return ResponseEntity.ok(StateResponseDto.fromEntityToResponse(state));
    }

    @DeleteMapping("/{acronym}")
    public ResponseEntity<StateResponseDto> deleteState(@PathVariable String acronym) throws DataNotFoundException {
        stateService.deleteState(acronym);
        return ResponseEntity.noContent().build();
    }

}
