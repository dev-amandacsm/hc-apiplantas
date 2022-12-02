package hcapiplantas.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import hcapiplantas.util.constant.GeneralConstants;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Getter
@Setter
@NoArgsConstructor
public class UserRequestDto {

    @NotBlank(message = GeneralConstants.NOT_BLANK_MESSAGE)
    @Length(max = 150)
    @JsonProperty("nome")
    private String name;

    @NotBlank(message = GeneralConstants.NOT_BLANK_MESSAGE)
    @Length(max = 45)
    @JsonProperty("login")
    private String login;

    @NotBlank(message = GeneralConstants.NOT_BLANK_MESSAGE)
    @Length(max = 45)
    @JsonProperty("senha")
    private String password;

    @NotBlank
    @JsonProperty("logradouro")
    @Pattern(regexp = GeneralConstants.NOT_SPECIAL_CHARACTER_45_PATTERN, message = GeneralConstants.OUTSIDE_EXPECTED_PATTERN_MESSAGE)
    private String street;

    @JsonProperty("complemento")
    @Pattern(regexp = GeneralConstants.NOT_SPECIAL_CHARACTER_45_PATTERN, message = GeneralConstants.OUTSIDE_EXPECTED_PATTERN_MESSAGE)
    private String addressComplement;

    @JsonProperty("nome_bairro")
    @Pattern(regexp = GeneralConstants.NOT_SPECIAL_CHARACTER_45_PATTERN, message = GeneralConstants.OUTSIDE_EXPECTED_PATTERN_MESSAGE)
    private String districtName;

}
