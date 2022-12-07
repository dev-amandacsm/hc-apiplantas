package hcapiplantas.config;

import hcapiplantas.model.entity.User;
import hcapiplantas.repository.UserRepository;
import hcapiplantas.service.impl.CategoryServiceImpl;
import hcapiplantas.service.impl.RestrictionServiceImpl;
import hcapiplantas.service.impl.SymptomServiceImpl;
import org.springframework.context.annotation.Bean;

import java.util.Optional;

@org.springframework.context.annotation.Configuration
public class Configuration {

    @Bean
    public SymptomServiceImpl symptomServiceImpl(){
        return new SymptomServiceImpl();
    }

    @Bean
    public RestrictionServiceImpl restrictionServiceImpl(){
        return new RestrictionServiceImpl();
    }

}
