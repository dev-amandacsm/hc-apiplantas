package hcapiplantas.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import hcapiplantas.model.entity.Restriction;
import hcapiplantas.util.constant.GeneralConstants;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class PlantRequestDto {

    @NotBlank(message = GeneralConstants.NOT_BLANK_MESSAGE)
    @Pattern(regexp = GeneralConstants.NOT_SPECIAL_CHARACTER_60_PATTERN, message = GeneralConstants.OUTSIDE_EXPECTED_PATTERN_MESSAGE)
    @JsonProperty("nome_popular")
    private String popularName;

    @NotBlank(message = GeneralConstants.NOT_BLANK_MESSAGE)
    @Pattern(regexp = GeneralConstants.NOT_SPECIAL_CHARACTER_60_PATTERN, message = GeneralConstants.OUTSIDE_EXPECTED_PATTERN_MESSAGE)
    @JsonProperty("nome_cientifico")
    private String scientificName;

    @NotBlank(message = GeneralConstants.NOT_BLANK_MESSAGE)
    @Length(max = 256)
    @JsonProperty("receita")
    private String recipe;

    @NotBlank(message = GeneralConstants.NOT_BLANK_MESSAGE)
    @Length(max = 256)
    @JsonProperty("descricao")
    private String description;

    @NotNull
    @JsonProperty("id_categoria")
    private Long categoryId;

    @Valid
    @NotNull
    @JsonProperty("sintomas")
    private Set<SymptomRequestDto> symptoms;

    @Valid
    @NotNull
    @JsonProperty("restricoes")
    private Set<Restriction> restrictions;
}
