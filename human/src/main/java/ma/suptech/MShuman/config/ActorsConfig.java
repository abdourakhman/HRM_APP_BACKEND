package ma.suptech.MShuman.config;

import ma.suptech.MShuman.services.ActorsService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ActorsConfig {
    private final ActorsService actorsService;

    public ActorsConfig(ActorsService actorsService) {
        this.actorsService = actorsService;
    }


    @Bean
    CommandLineRunner initActors(){
        return args -> {
            actorsService.initHumanResourceManager();
            actorsService.initManager();
            actorsService.initEmployee();
        };
    }
}
