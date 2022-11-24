package hcapiplantas.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import hcapiplantas.util.constant.GeneralConstants;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
@NoArgsConstructor
public class RestrictionRequestDto {

    @NotBlank(message = GeneralConstants.NOT_BLANK_MESSAGE)
    @Pattern(regexp = GeneralConstants.NOT_SPECIAL_CHARACTER_60_PATTERN, message=GeneralConstants.OUTSIDE_EXPECTED_PATTERN_MESSAGE)
    @JsonProperty("nome_grupo")
    private String groupName;

}
