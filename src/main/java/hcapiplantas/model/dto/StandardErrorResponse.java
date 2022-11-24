package hcapiplantas.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
public class StandardErrorResponse {

    private LocalDateTime timestamp;
    private HttpStatus status;
    private List<String> errors;

}
