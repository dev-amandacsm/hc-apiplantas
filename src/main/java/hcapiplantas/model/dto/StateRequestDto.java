package hcapiplantas.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import hcapiplantas.util.constant.GeneralConstants;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
public class StateRequestDto {

    @NotBlank(message = GeneralConstants.NOT_BLANK_MESSAGE)
    @Pattern(regexp = GeneralConstants.STATE_ACRONYM_CHARACTER_2_PATTERN, message=GeneralConstants.OUTSIDE_EXPECTED_PATTERN_MESSAGE)
    @JsonProperty("sigla_uf")
    private String acronym;

    @NotBlank(message = GeneralConstants.NOT_BLANK_MESSAGE)
    @Pattern(regexp = GeneralConstants.NOT_SPECIAL_CHARACTER_60_PATTERN, message=GeneralConstants.OUTSIDE_EXPECTED_PATTERN_MESSAGE)
    @JsonProperty("nome")
    private String name;

}
