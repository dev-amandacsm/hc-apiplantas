package hcapiplantas.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SymptomResponseDto {

    @JsonProperty("id")
    private String id;

    @JsonProperty("nome")
    private String name;

}
