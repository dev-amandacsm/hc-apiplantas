package hcapiplantas.controller;

import hcapiplantas.model.dto.RestrictionRequestDto;
import hcapiplantas.model.dto.RestrictionResponseDto;
import hcapiplantas.model.entity.Restriction;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/restricoes")
public class RestrictionController {

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
