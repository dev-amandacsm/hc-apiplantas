package hcapiplantas.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import hcapiplantas.model.entity.City;
import lombok.Builder;
import lombok.Data;

import java.net.URI;
import java.time.LocalDateTime;

@Data
@Builder
public class CityResponseDto {

    @JsonProperty("sigla_estado")
    private String acronym;

    @JsonProperty("nome")
    private String name;

    private URI link;

    private LocalDateTime timestamp;

    public static CityResponseDto fromEntityToResponse(City city) {
        return CityResponseDto.builder()
                .acronym(city.getState().getAcronym())
                .name(city.getName())
                .timestamp(LocalDateTime.now())
                .build();
    }
}
