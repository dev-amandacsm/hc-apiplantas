package hcapiplantas.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CategoryResponseDto {

    @JsonProperty("id")
    private String id;

    @JsonProperty("nome")
    private String name;

    @JsonProperty("descricao")
    private String description;

}
