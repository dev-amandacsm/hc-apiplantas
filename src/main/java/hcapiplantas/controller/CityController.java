package hcapiplantas.controller;

import hcapiplantas.exception.DataAlreadyExistsException;
import hcapiplantas.exception.DataNotFoundException;
import hcapiplantas.model.dto.CityRequestDto;
import hcapiplantas.model.dto.CityResponseDto;
import hcapiplantas.model.entity.City;
import hcapiplantas.model.entity.State;
import hcapiplantas.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/cidades")
public class CityController {

    @Autowired
    private CityService cityService;

    @PostMapping
    public ResponseEntity<CityResponseDto> createState(@Valid @RequestBody CityRequestDto request) throws URISyntaxException, DataNotFoundException, DataAlreadyExistsException {
        City city = cityService.createCity(request);
        CityResponseDto cityResponseDto = CityResponseDto.fromEntityToResponse(city);
        cityResponseDto.setLink(new URI(ServletUriComponentsBuilder.fromCurrentRequestUri().build() + "/" + city.getId()));
        return ResponseEntity.created(cityResponseDto.getLink()).body(cityResponseDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CityResponseDto> getCityById(@PathVariable String id) throws DataNotFoundException {
        City city = cityService.getCityById(id);
        return ResponseEntity.ok(CityResponseDto.fromEntityToResponse(city));
    }

    @GetMapping
    public ResponseEntity<List<CityResponseDto>> getAllCities() throws URISyntaxException {
        List<CityResponseDto> cityResponseDtoList = new ArrayList<>();
        List<City> cities = cityService.getAllCities();
        for (City c : cities) {
            CityResponseDto cityResponseDto = CityResponseDto.fromEntityToResponse(c);
            cityResponseDto.setLink(new URI(ServletUriComponentsBuilder.fromCurrentRequestUri().build() + "/" + c.getId()));
            cityResponseDtoList.add(cityResponseDto);

        }
        return ResponseEntity.ok(cityResponseDtoList);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CityResponseDto> deleteCity(@PathVariable Long id) throws DataNotFoundException {
        cityService.deleteCity(id);
        return ResponseEntity.noContent().build();
    }

}
