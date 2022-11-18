package hcapiplantas.model.dto;

import hcapiplantas.util.constant.GeneralConstants;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;

import java.net.URI;
import java.net.URISyntaxException;
import java.time.LocalDateTime;
import java.util.Arrays;

@Data
@RequiredArgsConstructor
public class StandardResponseDto {

    private Object data;
    private URI link;
    private LocalDateTime timestamp;

    @Profile("local")
    public void setLink(String[] activeProfiles, String resource, String resourceId) throws URISyntaxException {
        String host = Arrays.stream(activeProfiles).toList().contains("local") ? GeneralConstants.LOCAL_HOST : GeneralConstants.DEV_HOST;
        this.link = new URI(host + resource + "/" + resourceId);
    }
}
