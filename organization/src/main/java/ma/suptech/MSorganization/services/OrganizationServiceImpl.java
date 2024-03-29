package ma.suptech.MSorganization.services;

import jakarta.transaction.Transactional;
import ma.suptech.MSorganization.entities.Department;
import ma.suptech.MSorganization.entities.Job;
import ma.suptech.MSorganization.enumerations.Responsibility;
import ma.suptech.MSorganization.repositories.DepartmentRepository;
import ma.suptech.MSorganization.repositories.JobRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;
@Service
@Transactional
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
                "Secrétaire de bureau",
                "Formateur",
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
                "concevez l'architecture logicielle globale du système d'information",
                "Planifiez et supervisez des projets.",
                "Gérez les infrastructures système et réseau.",
                "Analysez et évaluez les performances financières.",
                "Créez des éléments graphiques pour divers projets.",
                "Dirigez et motivez une équipe de vente.",
                "Élaborez des stratégies de marketing et de publicité.",
                "Effectuez des traductions précises et de qualité.",
                "Prenez des rendez-vous et occupez vous de tout ce qui est  bureautique.",
                "Enseignez et transmettez des connaissances.",
                "Conseillez et accompagnez les employés et les RH.",
                "Assurez la maintenance et la réparation des équipements.",
                "Mettez en place des procédures qualité et des contrôles.",
                "Coordonnez et supervisez les projets de A à Z.",
                "Apportez un soutien administratif aux équipes.",
                "Assistez les dirigeants et gérez leurs agendas."
        ).toList();

        List<String> skillsJobs = Stream.of(
                "Java, Spring, SQL",
                "Analyse de données, SQL, Python",
                "Comptabilité, Gestion financière, Fiscalité",
                "Langage C, C++, Java, Algorithmes",
                "Architecture logicielle, Systèmes distribués",
                "Gestion de projet, Leadership, Communication",
                "Administration système, Réseaux",
                "Analyse financière, Prévisions, Reporting",
                "Design, Logiciels graphiques, Créativité",
                "Négociation, Prospection, Gestion de comptes",
                "SStratégie marketing, Analyse de marché",
                "Langues étrangères, Maîtrise des cultures",
                "Communication, Assiduité, Empathie, maîtrise suite bureautique",
                "Pédagogie, Gestion de classe, Matières enseignées",
                "Gestion des ressources humaines, Recrutement",
                "Maintenance préventive, Dépannage",
                "Contrôle qualité, Normes ISO",
                "Planification, Suivi, Résolution de problèmes",
                "Gestion administrative, Organisations",
                "Assistanat, Coordination, Communication"
        ).toList();

        for (int i =0; i<jobs.size();i++){
            Job job = new Job();
            job.setTitle(jobs.get(i));
            job.setDescription(jobDescriptions.get(i));
            job.setSkills(skillsJobs.get(i));
            job.setLevelOfResponsibility(responsibilities.get(new Random().nextInt(responsibilities.size())));
            if(Arrays.asList("Ingénieur logiciel","Architecte système", "Chef de projet","Comptable","Administrateur système")
                    .contains(job.getTitle()))
                job.setLevelOfResponsibility(Responsibility.HIGH);
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
