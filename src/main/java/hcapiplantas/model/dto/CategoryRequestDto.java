package hcapiplantas.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import hcapiplantas.util.constant.GeneralConstants;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
@Builder
public class CategoryRequestDto {

    @NotBlank(message = GeneralConstants.NOT_BLANK_MESSAGE)
    @Pattern(regexp = GeneralConstants.NOT_SPECIAL_CHARACTER_60_PATTERN, message=GeneralConstants.OUTSIDE_EXPECTED_PATTERN_MESSAGE)
    @JsonProperty("nome")
    private String name;

    @NotBlank(message = GeneralConstants.NOT_BLANK_MESSAGE)
    @Pattern(regexp = GeneralConstants.NOT_SPECIAL_CHARACTER_256_PATTERN, message=GeneralConstants.OUTSIDE_EXPECTED_PATTERN_MESSAGE)
    @JsonProperty("descricao")
    private String description;

}
