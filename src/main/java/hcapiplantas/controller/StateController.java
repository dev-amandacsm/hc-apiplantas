package hcapiplantas.controller;

import hcapiplantas.exception.DataAlreadyExistsException;
import hcapiplantas.model.dto.StateRequestDto;
import hcapiplantas.model.dto.StateResponseDto;
import hcapiplantas.model.entity.State;
import hcapiplantas.service.impl.StateServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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

}
