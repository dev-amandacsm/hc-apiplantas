package hcapiplantas.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import hcapiplantas.model.entity.City;
import hcapiplantas.model.entity.District;
import lombok.Builder;
import lombok.Data;

import java.net.URI;
import java.time.LocalDateTime;

@Data
@Builder
public class DistrictResponseDto {

    @JsonProperty("nome")
    private String name;

    @JsonProperty("nome_cidade")
    private String cityName;

    private URI link;

    private LocalDateTime timestamp;

    public static DistrictResponseDto fromEntityToResponse(District district) {
        return DistrictResponseDto.builder()
                .cityName(district.getCity().getName())
                .name(district.getName())
                .timestamp(LocalDateTime.now())
                .build();
    }
}
