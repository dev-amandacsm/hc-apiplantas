package hcapiplantas.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import hcapiplantas.model.entity.District;
import hcapiplantas.model.entity.Restriction;
import hcapiplantas.model.entity.Store;
import hcapiplantas.model.entity.Symptom;
import lombok.Builder;
import lombok.Data;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.LocalDateTime;
import java.util.stream.Collectors;

@Data
@Builder
public class StoreResponseDto {

    @JsonProperty("nome_social")
    private String name;

    @JsonProperty("descricao")
    private String description;

    @JsonProperty("contato")
    private String contact;

    @JsonProperty("logradouro")
    private String street;

    @JsonProperty("complemento")
    private String addressComplement;

    @JsonProperty("bairro")
    private District district;

    private URI link;

    private LocalDateTime timestamp;


    public static StoreResponseDto fromEntityToResponse(Store store) {
        return StoreResponseDto.builder()
                .name(store.getName())
                .description(store.getDescription())
                .contact(store.getContact())
                .street(store.getStreet())
                .addressComplement(store.getAddressComplement())
                .district(store.getDistrict())
                .timestamp(LocalDateTime.now())
                .build();
    }

}
