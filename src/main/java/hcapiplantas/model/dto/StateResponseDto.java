package hcapiplantas.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import hcapiplantas.model.entity.State;
import lombok.Builder;
import lombok.Data;

import java.net.URI;
import java.time.LocalDateTime;

@Data
@Builder
public class StateResponseDto {

    @JsonProperty("sigla_estado")
    private String acronym;

    @JsonProperty("nome")
    private String name;

    private URI link;

    private LocalDateTime timestamp;

    public static StateResponseDto fromEntityToResponse(State state) {
        return StateResponseDto.builder()
                .acronym(state.getAcronym())
                .name(state.getName())
                .timestamp(LocalDateTime.now())
                .build();
    }
}
