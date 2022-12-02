package hcapiplantas.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import hcapiplantas.model.entity.District;
import hcapiplantas.model.entity.Store;
import hcapiplantas.model.entity.User;
import lombok.Builder;
import lombok.Data;

import java.net.URI;
import java.time.LocalDateTime;

@Data
@Builder
public class UserResponseDto {

    @JsonProperty("nome")
    private String name;

    @JsonProperty("login")
    private String login;

    @JsonProperty("senha")
    private String password;

    @JsonProperty("logradouro")
    private String street;

    @JsonProperty("complemento")
    private String addressComplement;

    @JsonProperty("bairro")
    private District district;

    private URI link;

    private LocalDateTime timestamp;


    public static UserResponseDto fromEntityToResponse(User user) {
        return UserResponseDto.builder()
                .name(user.getName())
                .login(user.getLogin())
                .password(user.getPassword())
                .street(user.getStreet())
                .addressComplement(user.getAddressComplement())
                .district(user.getDistrict())
                .timestamp(LocalDateTime.now())
                .build();
    }

}
