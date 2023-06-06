package ma.suptech.MSorganization.config;

import ma.suptech.MSorganization.entities.Department;
import ma.suptech.MSorganization.entities.Job;
import ma.suptech.MSorganization.enumerations.Responsibility;
import ma.suptech.MSorganization.repositories.DepartmentRepository;
import ma.suptech.MSorganization.repositories.JobRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DepartmentConfig {
    private final DepartmentRepository departmentRepository;

    public DepartmentConfig(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Bean
    CommandLineRunner initJob(){
        return args -> {
            departmentRepository.save(new Department(null,"IT","processus et  services gérés par le département informatique"));
            departmentRepository.save(new Department(null,"FINANCE"," suivi des coûts, supervision de la comptabilité et  création de rapports"));
            departmentRepository.save(new Department(null,"COMPTABILITE","bilan,  compte de résultats et annexes, calcul  impôts dûs et  résultats fiscaux."));
            departmentRepository.save(new Department(null,"MARKETING","Moteur promotionnel de l'entreprise, chargé d'accroître la notoriété de la marque tout en attirant les clients potentiels et récurrents vers les produits et services de l'entreprise."));
            departmentRepository.save(new Department(null,"SERVICE CLIENT","département par lequel un client entre en communication avec l'entreprise pour nous faire part d'une interrogation, d'un ressenti ou d'un problème rencontré."));
        };
    }
}
