package ma.suptech.MSorganization.services;

import ma.suptech.MSorganization.entities.Department;
import ma.suptech.MSorganization.entities.Job;
import ma.suptech.MSorganization.enumerations.Responsibility;
import ma.suptech.MSorganization.repositories.DepartmentRepository;
import ma.suptech.MSorganization.repositories.JobRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

public class OrganizationServiceImpl implements OrganizationService {
    private final DepartmentRepository departmentRepository;
    private final JobRepository jobRepository;

    public OrganizationServiceImpl(DepartmentRepository departmentRepository, JobRepository jobRepository) {
        this.departmentRepository = departmentRepository;
        this.jobRepository = jobRepository;
    }

    @Override
    public void initJob() {
        List<Responsibility> responsibilities = Arrays.asList(Responsibility.LOW,Responsibility.MEDIUM,Responsibility.HIGH);
        List<String> jobs = Stream.of(
                "Développeur Java",
                "Data Analyst",
                "Comptable",
                "Ingénieur logiciel",
                "Architecte système",
                "Chef de projet",
                "Administrateur système",
                "Analyste financier",
                "Designer graphique",
                "Responsable des ventes",
                "Spécialiste en marketing",
                "Traducteur",
                "Infirmier",
                "Enseignant",
                "Consultant RH",
                "Technicien de maintenance",
                "Ingénieur qualité",
                "Gestionnaire de projet",
                "Assistant administratif",
                "Assistant de direction"
        ).toList();

        List<String> jobDescriptions = Stream.of(
                "Concevez et développez des applications Java.",
                "Analysez et interprétez des données pour des insights.",
                "Gérez les opérations comptables et financières.",
                "Concevez et développez des logiciels et des systèmes.",
                "Planifiez et supervisez des projets.",
                "Gérez les infrastructures système et réseau.",
                "Analysez et évaluez les performances financières.",
                "Créez des éléments graphiques pour divers projets.",
                "Dirigez et motivez une équipe de vente.",
                "Élaborez des stratégies de marketing et de publicité.",
                "Effectuez des traductions précises et de qualité.",
                "Fournissez des soins médicaux et infirmiers.",
                "Enseignez et transmettez des connaissances.",
                "Conseillez et accompagnez les employés et les RH.",
                "Assurez la maintenance et la réparation des équipements.",
                "Mettez en place des procédures qualité et des contrôles.",
                "Coordonnez et supervisez les projets de A à Z.",
                "Apportez un soutien administratif aux équipes.",
                "Assistez les dirigeants et gérez leurs agendas."
        ).toList();

        List<String> skillsJobs = Stream.of(
                "Développeur Java, Java, Spring, SQL",
                "Data Analyst, Analyse de données, SQL, Python",
                "Comptable, Comptabilité, Gestion financière, Fiscalité",
                "Ingénieur logiciel, Langage C, C++, Java, Algorithmes",
                "Architecte système, Architecture logicielle, Systèmes distribués",
                "Chef de projet, Gestion de projet, Leadership, Communication",
                "Administrateur système, Administration système, Réseaux",
                "Analyste financier, Analyse financière, Prévisions, Reporting",
                "Designer graphique, Design, Logiciels graphiques, Créativité",
                "Responsable des ventes, Négociation, Prospection, Gestion de comptes",
                "Spécialiste en marketing, Stratégie marketing, Analyse de marché",
                "Traducteur, Langues étrangères, Maîtrise des cultures",
                "Infirmier, Soins infirmiers, Santé, Empathie",
                "Enseignant, Pédagogie, Gestion de classe, Matières enseignées",
                "Consultant RH, Gestion des ressources humaines, Recrutement",
                "Technicien de maintenance, Maintenance préventive, Dépannage",
                "Ingénieur qualité, Contrôle qualité, Normes ISO",
                "Gestionnaire de projet, Planification, Suivi, Résolution de problèmes",
                "Assistant administratif, Gestion administrative, Organisations",
                "Assistant de direction, Assistanat, Coordination, Communication"
        ).toList();

        for (int i =0; i<jobs.size();i++){
            Job job = new Job();
            job.setTitle(jobs.get(i));
            job.setDescription(jobDescriptions.get(i));
            job.setSkills(skillsJobs.get(i));
            job.setLevelOfResponsibility(responsibilities.get(new Random().nextInt(responsibilities.size())));
            jobRepository.save(job);
        }

    }

    @Override
    public void initDepartment() {
        List<String> departments = Stream.of(
                "Informatique",
                "Analyse de données",
                "Finance",
               "Gestion de projet",
                "Design",
                "Ventes",
                "Marketing",
                "Traduction",
                "Formation",
                "Ressources humaines",
                "Maintenance",
                "Qualité",
                "Administration"
        ).toList();

        List<String> departmentDescriptions = new ArrayList<>();
        departmentDescriptions.add("Département chargé du développement et de la gestion des systèmes informatiques.");
        departmentDescriptions.add("Département responsable de l'analyse et de l'interprétation des données.");
        departmentDescriptions.add("Département en charge des activités financières et comptables de l'entreprise.");
        departmentDescriptions.add("Département responsable de la gestion et de la coordination des projets.");
        departmentDescriptions.add("Département dédié à la conception et à la création visuelle.");
        departmentDescriptions.add("Département responsable de la vente des produits ou services de l'entreprise.");
        departmentDescriptions.add("Département chargé de la promotion et de la commercialisation des produits ou services.");
        departmentDescriptions.add("Département spécialisé dans la traduction de documents et de contenus.");
        departmentDescriptions.add("Département en charge de la formation et du développement des compétences des employés.");
        departmentDescriptions.add("Département responsable de la gestion des ressources humaines et des relations sociales.");
        departmentDescriptions.add("Département chargé de la maintenance et de la réparation des équipements et infrastructures.");
        departmentDescriptions.add("Département responsable du contrôle qualité des produits ou services de l'entreprise.");
        departmentDescriptions.add("Département chargé de l'administration et de la gestion administrative générale.");

        for (int i=0; i<departments.size();i++){
            Department department = new Department();
            department.setName(departments.get(i));
            department.setDescription(departmentDescriptions.get(i));
            departmentRepository.save(department);
        }
    }
}
