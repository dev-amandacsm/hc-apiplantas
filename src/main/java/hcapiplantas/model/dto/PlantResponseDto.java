package hcapiplantas.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import hcapiplantas.model.entity.Category;
import lombok.Builder;
import lombok.Data;

import java.util.Set;

@Data
@Builder
public class PlantResponseDto {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("nome_popular")
    private String popularName;

    @JsonProperty("nome_cientifico")
    private String scientificName;

    @JsonProperty("receita")
    private String recipe;

    @JsonProperty("categoria")
    private Category category;

    @JsonProperty("sintomas")
    private Set<SymptomRequestDto> symptoms;

    @JsonProperty("restricoes")
    private Set<RestrictionRequestDto> restrictions;

}
