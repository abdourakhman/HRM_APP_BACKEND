package ma.suptech.MSresource.services;

import jakarta.transaction.Transactional;
import ma.suptech.MSresource.client.HumanRestClient;
import ma.suptech.MSresource.enumerations.Contract.Status;
import ma.suptech.MSresource.enumerations.Contract.Type;
import ma.suptech.MSresource.enumerations.timesheet.Absence;
import ma.suptech.MSresource.models.*;
import ma.suptech.MSresource.models.helper.Employee;
import ma.suptech.MSresource.models.helper.HumanResourceManager;
import ma.suptech.MSresource.models.helper.Manager;
import ma.suptech.MSresource.repositories.*;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

@Service
@Transactional
public class ResourceServiceImpl implements ResourceService {
    private final HumanRestClient humanRestClient;
    private final ContractRepository contractRepository;
    private final ProjectRepository projectRepository;
    private final GoalSetRepository goalSetRepository;
    private final TimeSheetRepository timeSheetRepository;
    private final TimeOffRequestRepository timeOffRequestRepository;

    List<String> projectNames = Stream.of(
            "Système de gestion des stocks",
            "Plateforme de réservation en ligne",
            "Application de suivi des dépenses",
            "Outil de gestion de projets",
            "Application de gestion des tâches",
            "Plateforme de streaming musical",
            "Application de gestion des contacts",
            "Système de réservation de billets d'avion",
            "Application de suivi de fitness",
            "Plateforme de e-commerce",
            "Système de suivi des livraisons",
            "Application de gestion des notes",
            "Plateforme de réseautage professionnel",
            "Système de gestion des ressources humaines",
            "Application de gestion de rendez-vous",
            "Plateforme de partage de photos",
            "Système de réservation de salles de réunion",
            "Application de suivi des dépenses personnelles",
            "Outil de gestion de temps",
            "Plateforme de blogging"
    ).toList();

    List<String> projectDescriptions = Stream.of(
            "Système de gestion des stocks, Un système informatisé pour gérer et contrôler les stocks d'une entreprise.",
            "Plateforme de réservation en ligne, Une application permettant aux utilisateurs de réserver des services en ligne, tels que des voyages, des hébergements, etc.",
            "Application de suivi des dépenses, Une application qui aide les utilisateurs à suivre et gérer leurs dépenses financières.",
            "Outil de gestion de projets, Un outil permettant de planifier, organiser et suivre les différentes tâches et activités d'un projet.",
            "Application de gestion des tâches, Une application qui permet de créer, organiser et suivre les tâches à réaliser.",
            "Plateforme de streaming musical, Un service en ligne permettant d'écouter et de découvrir de la musique en streaming.",
            "Application de gestion des contacts, Une application qui permet de gérer et organiser les contacts personnels ou professionnels.",
            "Système de réservation de billets d'avion, Un système permettant aux utilisateurs de réserver des billets d'avion en ligne.",
            "Application de suivi de fitness, Une application qui aide les utilisateurs à suivre et enregistrer leurs activités physiques et leur condition physique.",
            "Plateforme de e-commerce, Une plateforme en ligne pour acheter et vendre des produits ou services.",
            "Système de suivi des livraisons, Un système permettant de suivre et de gérer les livraisons de produits ou colis.",
            "Application de gestion des notes, Une application pour prendre, organiser et gérer des notes et des informations.",
            "Plateforme de réseautage professionnel, Une plateforme en ligne pour établir des connexions et des interactions professionnelles.",
            "Système de gestion des ressources humaines, Un système informatisé pour gérer les processus liés aux ressources humaines d'une organisation.",
            "Application de gestion de rendez-vous, Une application pour planifier et gérer des rendez-vous ou des horaires.",
            "Plateforme de partage de photos, Une plateforme en ligne pour partager et découvrir des photos.",
            "Système de réservation de salles de réunion, Un système permettant de réserver et de gérer les salles de réunion dans une organisation.",
            "Application de suivi des dépenses personnelles, Une application qui aide les utilisateurs à suivre et gérer leurs dépenses personnelles et leur budget.",
            "Outil de gestion de temps, Un outil pour suivre et gérer efficacement le temps alloué à différentes tâches et activités.",
            "Plateforme de blogging, Une plateforme en ligne pour créer et publier des articles, des billets de blog et des contenus écrits."
    ).toList();
    List<String> goalsets = Stream.of(
            "Optimiser les processus de gestion des stocks, Réduire les coûts liés aux stocks",
            "Améliorer la performance et la sécurité du système",
            "Faciliter la réservation en ligne et la gestion des disponibilités",
            "Suivre et catégoriser les dépenses, Générer des rapports détaillés",
            "Organiser et hiérarchiser les tâches, Suivre l'avancement du projet",
            "Diffuser de la musique en continu, Recommander des playlists personnalisées",
            "Gérer les contacts, Ajouter, supprimer et rechercher des contacts",
            "Faciliter la réservation de billets d'avion, Comparer les prix",
            "Suivre les activités physiques, Enregistrer les progrès et les objectifs",
            "Faciliter les achats en ligne, Gérer les commandes et les paiements",
            "Suivre les livraisons, Recevoir des notifications en temps réel",
            "Prendre des notes, Organiser et partager des informations",
            "Établir des connexions professionnelles, Partager des opportunités",
            "Gérer les ressources humaines, Suivre les employés et les performances",
            "Planifier et gérer les rendez-vous, Recevoir des rappels",
            "Partager des photos, Appliquer des filtres et des effets",
            "Réserver des salles de réunion, Vérifier la disponibilité et les équipements",
            "Suivre les dépenses personnelles, Analyser les habitudes de consommation",
            "Gérer le temps, Planifier les activités et les rappels",
            "Partager des articles, Écrire des blogs et interagir avec la communauté"
    ).toList();

    public ResourceServiceImpl(HumanRestClient humanRestClient, ContractRepository contractRepository, ProjectRepository projectRepository, GoalSetRepository goalSetRepository, TimeSheetRepository timeSheetRepository, TimeOffRequestRepository timeOffRequestRepository) {
        this.humanRestClient = humanRestClient;
        this.contractRepository = contractRepository;
        this.projectRepository = projectRepository;
        this.goalSetRepository = goalSetRepository;
        this.timeSheetRepository = timeSheetRepository;
        this.timeOffRequestRepository = timeOffRequestRepository;
    }

    @Override
    public void initContract() {
        for(Employee employee: humanRestClient.listEmployee()){
            Contract contract = new Contract();
            contract.setStart(employee.getHiringDate());
            contract.setType(Arrays.asList(Type.CDD,Type.CDI,Type.ALTERNATION).get(new Random().nextInt(3)));
            if(contract.getType().equals(Type.CDI))
                contract.setEnd(null);
            else
                contract.setEnd(contract.getStart().plusYears(new Random().nextInt(2,10)));
            contract.setRemuneration((new Random().nextInt(5,20)*1000));
            contract.setStatus(Arrays.asList(Status.ACTIVE,Status.REVOKED,Status.EXPIRED).get(new Random().nextInt(3)));
            if (contract.getStatus().equals(Status.EXPIRED))
                contract.setEnd(LocalDate.now().minusYears(new Random().nextInt(2)).minusMonths(new Random().nextInt(10)));
            if(contract.getStatus().equals(Status.REVOKED))
                contract.setEnd(null);
            contract.setEmployee(employee);
            List<HumanResourceManager> humanResourceManagers = new ArrayList<>();
            humanRestClient.listRh().forEach(rh ->{
                for (Employee e: humanRestClient.listEmployee()){
                    if(e.getRegistrationNumber().equals(rh.getRegistrationNumber()))
                        if(e.getDepartmentID().equals(employee.getDepartmentID()))
                            humanResourceManagers.add(rh);
                }
            });
            contract.setHumanResourceManager(humanResourceManagers.get(new Random().nextInt(humanResourceManagers.size())));
            contract.setEmployeeID(employee.getId());
            contract.setHumanResourceManagerID(contract.getHumanResourceManager().getId());
            contractRepository.save(contract);
        }

    }

    @Override
    public void initProject() {
        for(int i=0; i<projectNames.size();i++){
            Project project = new Project();
            project.setName(projectNames.get(i));
            project.setDescription(projectDescriptions.get(i));
            project.setStart(LocalDate.now().minusYears(new Random().nextInt(2)));
            project.setEnd(LocalDate.now().plusYears(new Random().nextInt(2,10)));
            List<Manager> managers = humanRestClient.listManager();
            project.setManager(managers.get(new Random().nextInt(managers.size())));
            project.setManagerID(project.getManager().getId());
            projectRepository.save(project);
        }
    }

    @Override
    public void initGoalSet() {
        for(int i = 0; i < projectRepository.findAll().size(); i++){
            List<Employee> employees = humanRestClient.listEmployee();
            humanRestClient.listEmployee().forEach(employee -> {
                for(Manager manager: humanRestClient.listManager())
                    if(employee.getRegistrationNumber().equals(manager.getRegistrationNumber()))
                            employees.remove(employee);

                for(HumanResourceManager rh : humanRestClient.listRh())
                    if(rh.getRegistrationNumber().equals(employee.getRegistrationNumber()))
                        employees.remove(employee);

            });
            GoalSet goalSet = new GoalSet();
            goalSet.setTitle(goalsets.get(i));
            goalSet.setProject(projectRepository.findById((long)i).get());
            goalSet.setTargetDate(goalSet.getProject().getStart().plusMonths(new Random().nextInt(3)));
            goalSet.setEmployee(employees.get(new Random().nextInt(employees.size())));
            goalSet.setEmployeeID(goalSet.getEmployee().getId());
            goalSetRepository.save(goalSet);
        }
    }

    @Override
    public void initTimesheet() {
        for (Employee employee: humanRestClient.listEmployee()) {
            TimeSheet timeSheet = new TimeSheet();
            timeSheet.setCreatedAt(LocalDate.now());
            timeSheet.setAbsence(Arrays.asList(Absence.DISEASE,Absence.FORMATION,Absence.HOLIDAYS,Absence.OTHER,null).get(new Random().nextInt(4)));
            if(timeSheet.getAbsence() != null)
                timeSheet.setAbsence(null);
            else
                timeSheet.setHoursWorked(Duration.ofHours(new Random().nextInt(5,8)));
            timeSheet.setEmployeeID(employee.getId());
            timeSheet.setEmployee(employee);
            timeSheetRepository.save(timeSheet);
        }
    }

    @Override
    public void initRequestTimeOff() {
        for (int i =0; i<30;i++) {
            Employee employee = humanRestClient.listEmployee().get(new Random().nextInt(humanRestClient.listEmployee().size()));
            TimeOffRequest timeOffRequest = new TimeOffRequest();
            timeOffRequest.setType(Arrays.asList(ma.suptech.MSresource.enumerations.timeOffRequest.Type.ANNUAL,
                    ma.suptech.MSresource.enumerations.timeOffRequest.Type.MATERNITY,
                    ma.suptech.MSresource.enumerations.timeOffRequest.Type.DISEASE,
                    ma.suptech.MSresource.enumerations.timeOffRequest.Type.FORMATION,
                    ma.suptech.MSresource.enumerations.timeOffRequest.Type.OTHER
                    ).get(new Random().nextInt(5)));
            if(timeOffRequest.getType().equals(ma.suptech.MSresource.enumerations.timeOffRequest.Type.MATERNITY))
                timeOffRequest.setRequestStatus(ma.suptech.MSresource.enumerations.timeOffRequest.Status.ACCEPTED);
            else
                timeOffRequest.setRequestStatus(Arrays.asList(
                        ma.suptech.MSresource.enumerations.timeOffRequest.Status.ACCEPTED,
                        ma.suptech.MSresource.enumerations.timeOffRequest.Status.PENDING,
                        ma.suptech.MSresource.enumerations.timeOffRequest.Status.REJECTED
                ).get(new Random().nextInt(3)));
            timeOffRequest.setDesiredStartDate(LocalDate.now().plusMonths(new Random().nextInt(2)));
            if(timeOffRequest.getType().equals(ma.suptech.MSresource.enumerations.timeOffRequest.Type.MATERNITY))
                timeOffRequest.setDesiredEndDate(timeOffRequest.getDesiredStartDate().plusMonths(3));
            else
                timeOffRequest.setDesiredEndDate(timeOffRequest.getDesiredStartDate().plusWeeks(new Random().nextInt(1,4)));
            timeOffRequest.setEmployee(employee);
            timeOffRequest.setEmployeeID(employee.getId());

            List<HumanResourceManager> humanResourceManagers = new ArrayList<>();
            humanRestClient.listRh().forEach(rh ->{
                for(Employee employee1: humanRestClient.listEmployee())
                    if(employee1.getRegistrationNumber().equals(rh.getRegistrationNumber()))
                        if(employee1.getDepartmentID().equals(employee.getDepartmentID()))
                            humanResourceManagers.add(rh);
            });
            if(humanResourceManagers.size()>0) {
                timeOffRequest.setHumanResourceManager(humanResourceManagers.get(new Random().nextInt(humanResourceManagers.size())));
                timeOffRequest.setHumanResourceManagerID(timeOffRequest.getHumanResourceManager().getId());
            }
            timeOffRequestRepository.save(timeOffRequest);
        }
    }
}
