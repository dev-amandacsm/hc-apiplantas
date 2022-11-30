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
import javax.validation.constraints.Size;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class StoreRequestDto {

    @NotBlank(message = GeneralConstants.NOT_BLANK_MESSAGE)
    @Pattern(regexp = GeneralConstants.NOT_SPECIAL_CHARACTER_45_PATTERN, message = GeneralConstants.OUTSIDE_EXPECTED_PATTERN_MESSAGE)
    @JsonProperty("nome_social")
    private String name;

    @NotBlank(message = GeneralConstants.NOT_BLANK_MESSAGE)
    @Pattern(regexp = GeneralConstants.NOT_SPECIAL_CHARACTER_256_PATTERN, message = GeneralConstants.OUTSIDE_EXPECTED_PATTERN_MESSAGE)
    @JsonProperty("descricao")
    private String description;

    @NotBlank(message = GeneralConstants.NOT_BLANK_MESSAGE)
    @Length(max = 60)
    @JsonProperty("contato")
    private String contact;

    @NotBlank
    @JsonProperty("logradouro")
    @Pattern(regexp = GeneralConstants.NOT_SPECIAL_CHARACTER_60_PATTERN, message = GeneralConstants.OUTSIDE_EXPECTED_PATTERN_MESSAGE)
    private String street;

    @JsonProperty("complemento")
    @Pattern(regexp = GeneralConstants.NOT_SPECIAL_CHARACTER_45_PATTERN, message = GeneralConstants.OUTSIDE_EXPECTED_PATTERN_MESSAGE)
    private String addressComplement;

    @JsonProperty("nome_bairro")
    @Pattern(regexp = GeneralConstants.NOT_SPECIAL_CHARACTER_45_PATTERN, message = GeneralConstants.OUTSIDE_EXPECTED_PATTERN_MESSAGE)
    private String districtName;

}
