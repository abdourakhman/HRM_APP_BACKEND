package ma.suptech.MSorganization.config;

import ma.suptech.MSorganization.services.OrganizationService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OrganizationConfig {
    private final OrganizationService organizationService;

    public OrganizationConfig(OrganizationService organizationService) {
        this.organizationService = organizationService;
    }

    @Bean
    CommandLineRunner initOrganization(){
        return args -> {
            organizationService.initDepartment();
            organizationService.initJob();
        };
    }
}
