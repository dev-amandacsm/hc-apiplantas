package hcapiplantas.config;

import hcapiplantas.service.impl.CategoryServiceImpl;
import hcapiplantas.service.impl.RestrictionServiceImpl;
import hcapiplantas.service.impl.SymptomServiceImpl;
import org.springframework.context.annotation.Bean;

@org.springframework.context.annotation.Configuration
public class Configuration {

    @Bean
    public CategoryServiceImpl categoryServiceImpl(){
        return new CategoryServiceImpl();
    }

    @Bean
    public SymptomServiceImpl symptomServiceImpl(){
        return new SymptomServiceImpl();
    }

    @Bean
    public RestrictionServiceImpl restrictionServiceImpl(){
        return new RestrictionServiceImpl();
    }

}
