package hcapiplantas.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import hcapiplantas.model.entity.Plant;
import hcapiplantas.model.entity.Restriction;
import hcapiplantas.model.entity.Symptom;
import lombok.Builder;
import lombok.Data;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.stream.Collectors;

@Data
@Builder
public class PlantResponseDto {

    @JsonProperty("nome_popular")
    private String popularName;

    @JsonProperty("nome_cientifico")
    private String scientificName;

    @JsonProperty("receita")
    private String recipe;

    @JsonProperty("descricao")
    private String description;

    @JsonProperty("categoria")
    private String category;

    @JsonProperty("descricao_categoria")
    private String categoryDescription;

    @JsonProperty("sintomas")
    private Set<String> symptoms;

    @JsonProperty("restricoes")
    private Set<String> restrictions;

    private URI link;

    private LocalDateTime timestamp;

    public static PlantResponseDto fromEntityToResponse(Plant plant) throws URISyntaxException, MalformedURLException {
        return PlantResponseDto.builder()
                .popularName(plant.getPopularName())
                .scientificName(plant.getScientificName())
                .recipe(plant.getRecipe())
                .description(plant.getDescription())
                .category(plant.getCategory().getName())
                .categoryDescription(plant.getCategory().getDescription())
                .symptoms(plant.getSymptoms().stream().map(Symptom::getName).collect(Collectors.toSet()))
                .restrictions(plant.getRestrictions().stream().map(Restriction::getGroupName).collect(Collectors.toSet()))
                .timestamp(LocalDateTime.now())
                .build();
    }

}
