package ma.suptech.MShuman.config;

import ma.suptech.MShuman.enumerations.Gender;
import ma.suptech.MShuman.enumerations.Status;
import ma.suptech.MShuman.models.Employee;
import ma.suptech.MShuman.models.HumanResourceManager;
import ma.suptech.MShuman.models.Manager;
import ma.suptech.MShuman.services.EmployeeService;
import ma.suptech.MShuman.services.HumanResourceManagerService;
import ma.suptech.MShuman.services.ManagerService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;

@Configuration
public class ActorsConfig {
    private final EmployeeService employeeService;
    private final ManagerService managerService;
    private final HumanResourceManagerService humanResourceManagerService;

    public ActorsConfig(EmployeeService employeeService, ManagerService managerService, HumanResourceManagerService humanResourceManagerService) {
        this.employeeService = employeeService;
        this.managerService = managerService;
        this.humanResourceManagerService = humanResourceManagerService;
    }

    @Bean
    CommandLineRunner initActors(){
        return args -> {
            //init human resource manager
            humanResourceManagerService.save(new HumanResourceManager(null,"Diop","Cherif mohamed", Gender.FEMALE, LocalDate.of(1988, 11, 14),"GIRONDE",77696442,"cherif@gmail.com",LocalDate.of(2002,2,16), Status.ACTIVE,"https://img.freepik.com/photos-gratuite/portrait-beau-jeune-homme-affaires-noir-africain-travaillant-ordinateur-portable-au-bureau_231208-680.jpg",4L,5L,null,null));
            humanResourceManagerService.save(new HumanResourceManager(null,"Mendy","Sylvie", Gender.FEMALE, LocalDate.of(1997, 1, 22),"MERS SULTAN",678963550,"sylvie@gmail.com",LocalDate.of(2006,6,17), Status.ACTIVE,"https://img.freepik.com/photos-premium/concept-education-affaires-technologie-femme-affaires-etudiante-afro-americaine-heureuse-ordinateur-portable-papiers-au-bureau_380164-102055.jpg",1L,5L,null,null));


            //init manager
            managerService.save(new Manager(null,"Aimeddine","Hamza", Gender.MALE, LocalDate.of(1979, 7, 3),"JADDIDA",772963002,"hamza@gmail.com",LocalDate.of(2000,3,10), Status.ACTIVE,"https://img.freepik.com/photos-gratuite/portrait-beau-jeune-homme-affaires-noir-africain-travaillant-ordinateur-portable-au-bureau_231208-680.jpg",null,4L,3L,null,null));
            managerService.save(new Manager(null,"Kassidh","Salma", Gender.FEMALE, LocalDate.of(1995, 1, 23),"DERB OMAR",772963550,"salma@gmail.com",LocalDate.of(2020,9,17), Status.ACTIVE,"https://img.freepik.com/photos-premium/concept-education-affaires-technologie-femme-affaires-etudiante-afro-americaine-heureuse-ordinateur-portable-papiers-au-bureau_380164-102055.jpg",null,1L,1L,null,null));

            //init employees
            employeeService.save(new Employee(null,"Ndiaye","Abdallah", Gender.MALE, LocalDate.of(1999, 7, 31),"MAARIF",612963002,"abdourakhman920@gmail.com",LocalDate.of(2023,4,10), Status.ACTIVE,"https://img.freepik.com/photos-gratuite/portrait-beau-jeune-homme-affaires-noir-africain-travaillant-ordinateur-portable-au-bureau_231208-680.jpg",null,1L,1L,null,null));
            employeeService.save(new Employee(null,"Ndiaye","Abdourahmane", Gender.MALE, LocalDate.of(1999, 7, 31),"MAARIF",612963002,"abdourakhman920@gmail.com",LocalDate.of(2023,4,10), Status.ACTIVE,"https://img.freepik.com/photos-gratuite/portrait-beau-jeune-homme-affaires-noir-africain-travaillant-ordinateur-portable-au-bureau_231208-680.jpg",null,1L, 1L,null, null));
            employeeService.save(new Employee(null,"Faye","Bousso", Gender.FEMALE , LocalDate.of(1967, 7, 25),"DALIFORT",612962002,"BoussoFaye@gmail.com",LocalDate.of(1980,1,10),Status.ACTIVE,"https://img.freepik.com/photos-gratuite/concept-reussite-professionnelle-executive-femme-affaires_53876-137644.jpg",null,1L,1L,null,null));
            employeeService.save(new Employee(null,"Kane","Mohamed", Gender.MALE, LocalDate.of(1979, 7, 21),"MARISTE",712963005,"MOHAMED&&@gmail.com",LocalDate.of(1986,6,30), Status.ACTIVE,"https://thumbs.dreamstime.com/z/homme-africain-d-affaires-51091489.jpg",null,2L,2L,null,null));
            employeeService.save(new Employee(null,"Mbacke","Ndeye Fatou",Gender.FEMALE , LocalDate.of(1980, 9, 15),"BELVEDRE",612962332,"Mbackeballa@gmail.com",LocalDate.of(2003,8,12), Status.INACTIVE,"https://img.freepik.com/photos-premium/concept-education-affaires-technologie-femme-affaires-etudiante-afro-americaine-heureuse-ordinateur-portable-papiers-au-bureau_380164-102055.jpg",null,2L,3L,null,null));
        };
    }
}
