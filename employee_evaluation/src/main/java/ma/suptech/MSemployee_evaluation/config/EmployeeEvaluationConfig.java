package ma.suptech.MSemployee_evaluation.config;

import ma.suptech.MSemployee_evaluation.ennumerations.Gender;
import ma.suptech.MSemployee_evaluation.ennumerations.Profile;
import ma.suptech.MSemployee_evaluation.ennumerations.Status;
import ma.suptech.MSemployee_evaluation.entities.Employee;
import ma.suptech.MSemployee_evaluation.entities.Evaluation;
import ma.suptech.MSemployee_evaluation.entities.SpecificNote;
import ma.suptech.MSemployee_evaluation.repositories.EvaluationRepository;
import ma.suptech.MSemployee_evaluation.services.EmployeeService;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Set;


@Configuration
public class EmployeeEvaluationConfig {
    private final EmployeeService employeeService;
    private final EvaluationRepository evaluationRepository;

    public EmployeeEvaluationConfig(EmployeeService employeeService, EvaluationRepository evaluationRepository){
        this.employeeService = employeeService;
        this.evaluationRepository = evaluationRepository;
    }

    @Bean
    CommandLineRunner initEmployee(){
        return args ->{
            Evaluation evaluation2020 = evaluationRepository.save(new Evaluation(null,  LocalDate.now(),"L'objectif principal était d'augmenter les ventes de 10% ce trimestre.",Evaluation.SpecificNote(Arrays.asList(
                    new SpecificNote("gestion du temps",6,"L'employé peut améliorer sa gestion du temps pour respecter les délais des projets."),
                    new SpecificNote("collaboration",9,"L'employé a travaillé de manière collaborative avec les membres de son équipe"),
                    new SpecificNote("Compétences en Pen testing",10,"L'employé a démontré d'excellentes compétences en test pénétration")
            )),
                    "Je recommande à l'employé de suivre une formation sur la gestion du temps pour renforcer ses compétences dans ce domaine.",null
            ));
            employeeService.save(new Employee(null,"Ndiaye","Abdallah", Gender.MALE, LocalDate.of(1999, 7, 31),"MAARIF",612963002,"abdourakhman920@gmail.com",LocalDate.of(2023,4,10), Profile.ADMINISTRATOR, Status.ACTIVE,"https://img.freepik.com/photos-gratuite/portrait-beau-jeune-homme-affaires-noir-africain-travaillant-ordinateur-portable-au-bureau_231208-680.jpg",null,null,null,null,null, null));
            employeeService.save(new Employee(null,"Ndiaye","Abdourahmane", Gender.MALE, LocalDate.of(1999, 7, 31),"MAARIF",612963002,"abdourakhman920@gmail.com",LocalDate.of(2023,4,10), Profile.MANAGER, Status.ACTIVE,"https://img.freepik.com/photos-gratuite/portrait-beau-jeune-homme-affaires-noir-africain-travaillant-ordinateur-portable-au-bureau_231208-680.jpg",null,1L,1L, Set.of(evaluation2020),null, null));
            employeeService.save(new Employee(null,"Faye","Bousso", Gender.FEMALE , LocalDate.of(1967, 7, 25),"DALIFORT",612962002,"BoussoFaye@gmail.com",LocalDate.of(1980,1,10), Profile.EMPLOYEE,Status.ACTIVE,"https://img.freepik.com/photos-gratuite/concept-reussite-professionnelle-executive-femme-affaires_53876-137644.jpg",2L,1L,1L,null,null,null));
            employeeService.save(new Employee(null,"Kane","Mohamed", Gender.MALE, LocalDate.of(1979, 7, 21),"MARISTE",712963005,"MOHAMED&&@gmail.com",LocalDate.of(1986,6,30), Profile.EMPLOYEE,Status.ACTIVE,"https://thumbs.dreamstime.com/z/homme-africain-d-affaires-51091489.jpg",1L,1L,1L,null,null,null));
            employeeService.save(new Employee(null,"Mbacke","Ndeye Fatou",Gender.FEMALE , LocalDate.of(1980, 9, 15),"BELVEDRE",612962332,"Mbackeballa@gmail.com",LocalDate.of(2003,8,12),Profile.HUMAN_RESOURCE_MANAGER, Status.INACTIVE,"https://img.freepik.com/photos-premium/concept-education-affaires-technologie-femme-affaires-etudiante-afro-americaine-heureuse-ordinateur-portable-papiers-au-bureau_380164-102055.jpg",3L,2L,2L,null,null,null));
        };
    }

}
