package hcapiplantas.config;

import hcapiplantas.service.impl.CategoryServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;

@org.springframework.context.annotation.Configuration
public class Configuration {

    @Bean
    public CategoryServiceImpl service(){
        return new CategoryServiceImpl();
    }

}
