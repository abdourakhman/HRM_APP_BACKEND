package ma.suptech.MSresource.config;

import ma.suptech.MSresource.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class ResourceConfig {
    private final ResourceService resourceService;

    public ResourceConfig(ResourceService resourceService) {
        this.resourceService = resourceService;
    }


    @Bean
    CommandLineRunner initResource(){
       return args -> {
           resourceService.initContract();
           resourceService.initProject();
           resourceService.initGoalSet();
           resourceService.initTimesheet();
           resourceService.initRequestTimeOff();
       };
    }
}
