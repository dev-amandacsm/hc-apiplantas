package hcapiplantas.controller;

import hcapiplantas.exception.DataAlreadyExistsException;
import hcapiplantas.exception.DataNotFoundException;
import hcapiplantas.model.dto.DistrictRequestDto;
import hcapiplantas.model.dto.DistrictResponseDto;
import hcapiplantas.model.entity.District;
import hcapiplantas.service.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/bairros")
public class DistrictController {

    @Autowired
    private DistrictService districtService;

    @PostMapping
    public ResponseEntity<DistrictResponseDto> createState(@Valid @RequestBody DistrictRequestDto request) throws URISyntaxException, DataNotFoundException, DataAlreadyExistsException {
        District district = districtService.createDistrict(request);
        DistrictResponseDto districtResponseDto = DistrictResponseDto.fromEntityToResponse(district);
        districtResponseDto.setLink(new URI(ServletUriComponentsBuilder.fromCurrentRequestUri().build() + "/" + district.getId()));
        return ResponseEntity.created(districtResponseDto.getLink()).body(districtResponseDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DistrictResponseDto> getCityById(@PathVariable String id) throws DataNotFoundException {
        District district = districtService.getDistrictById(id);
        return ResponseEntity.ok(DistrictResponseDto.fromEntityToResponse(district));
    }

    @GetMapping
    public ResponseEntity<List<DistrictResponseDto>> getAllDistricts() throws URISyntaxException {
        List<DistrictResponseDto> districtResponseDtoList = new ArrayList<>();
        List<District> districts = districtService.getAllDistricts();
        for (District d : districts) {
            DistrictResponseDto districtResponseDto = DistrictResponseDto.fromEntityToResponse(d);
            districtResponseDto.setLink(new URI(ServletUriComponentsBuilder.fromCurrentRequestUri().build() + "/" + d.getId()));
            districtResponseDtoList.add(districtResponseDto);

        }
        return ResponseEntity.ok(districtResponseDtoList);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DistrictResponseDto> deleteDistrict(@PathVariable Long id) throws DataNotFoundException {
        districtService.deleteDistrict(id);
        return ResponseEntity.noContent().build();
    }

}
