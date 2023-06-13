package ma.suptech.MSresource.config;

import ma.suptech.MSresource.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;


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

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.setAllowCredentials(true);
        corsConfiguration.setAllowedOrigins(Arrays.asList("http://localhost:4200"));
        corsConfiguration.setAllowedHeaders(Arrays.asList("Origin","Access-Control-Allow-Origin","Content-Type",
                "Accept","Jwt-Token","Authorization","Origin, Accept","X-Requested-With","Access-Control-Request-Method",
                "Access-Control-Request-Headers"));
        corsConfiguration.setExposedHeaders(Arrays.asList("Origin","Access-Control-Allow-Origin","Content-Type",
                "Access-Control-Allow-Credentials","Filename",
                "Accept","Jwt-Token","Authorization","Origin, Accept","X-Requested-With","Access-Control-Request-Method",
                "Access-Control-Request-Headers"));
        corsConfiguration.setAllowedMethods(Arrays.asList("GET","POST","PUT","DELETE","OPTIONS"));
        urlBasedCorsConfigurationSource.registerCorsConfiguration("/**",corsConfiguration);
        return new CorsFilter(urlBasedCorsConfigurationSource);
    }
}
