/*
package ma.suptech.MSorganization.config;

import ma.suptech.MSorganization.entities.Job;
import ma.suptech.MSorganization.enumerations.Responsibility;
import ma.suptech.MSorganization.repositories.JobRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


public class JobConfig {
    private final JobRepository jobRepository;

    public JobConfig(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    CommandLineRunner initDepartment(){
        return args -> {
            jobRepository.save(new Job(null,"développeur fullStack","développeur adroit dans plusieurs technologies","Java Php,BDD", Responsibility.MEDIUM));
            jobRepository.save(new Job(null,"admin système","gère le système informatique de l'entreprise","administration Linux, Administration windows ", Responsibility.HIGH));
            jobRepository.save(new Job(null,"developpeur java junior ","gère les fonctionnalités des applications données par les manager","java, algorithmie ", Responsibility.LOW));
            jobRepository.save(new Job(null,"chef equipe ","gère et anime une ou plusieurs équipes de collaborateurs","Gestion des objectifs, gestion planning, bonne communication ", Responsibility.HIGH));
            jobRepository.save(new Job(null,"responsable RH","est chargé de diriger la stratégie de gestion du personnel et du développement des effectifs au sein d'une entreprise.","Un leadership naturel. ... Une bonne communication,Un sens de l'empathie et de l'écoute développé,Un esprit d'équipe redoutable, une capacité à bien s'organiser et anticiper", Responsibility.HIGH));
            jobRepository.save(new Job(null,"secrétaire ","consiste à s'occuper, pour le compte d'un autre employé ou agent, de son courrier, de ses communications téléphoniques, de la rédaction des comptes rendus de réunions, de la gestion de son emploi du temps.","communication, bureautique ", Responsibility.LOW));
        };
    }
}
*/
