package ma.suptech.MSevaluation.config;

import lombok.AllArgsConstructor;
import ma.suptech.MSevaluation.client.HumanRestClient;
import ma.suptech.MSevaluation.models.Evaluation;
import ma.suptech.MSevaluation.models.ScoreCard;
import ma.suptech.MSevaluation.models.helper.Employee;
import ma.suptech.MSevaluation.models.helper.Manager;
import ma.suptech.MSevaluation.models.helper.SpecificNote;
import ma.suptech.MSevaluation.services.EvaluationService;
import ma.suptech.MSevaluation.services.ScoreCardService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

@Configuration
@AllArgsConstructor
public class EvaluationConfig {
    private final EvaluationService evaluationService;
    private final ScoreCardService scoreCardService;
    private final HumanRestClient humanRestClient;


    @Bean
    CommandLineRunner initEvaluation(){
        return  args -> {
            List<String> evaluationTitles = Stream.of(
                    "Evaluation annuelle",
                    "Evaluation de performance",
                    "Evaluation 360 degrés",
                    "Evaluation de compétences",
                    "Evaluation de développement"
            ).toList();
            List<Employee> employees = humanRestClient.listEmployee();
            humanRestClient.listEmployee().forEach(employee -> {
                for(Manager manager: humanRestClient.listManager()) {
                    if (employee.getRegistrationNumber().equals(manager.getRegistrationNumber()))
                        employees.remove(employee);
                    if (employee.getJobID().equals(15L))
                        employees.remove(employee);
                }
            });
            for(int i = 0; i<5; i++){
                Evaluation evaluation = new Evaluation();
                evaluation.setEvaluationDate(LocalDate.now().minusWeeks(new Random().nextInt(4)));
                evaluation.setGoalSet(evaluationTitles.get(i));
                evaluationService.save(evaluation);

                scoreCardService.save(
                        new ScoreCard(null,ScoreCard.SpecificNote(Arrays.asList(
                                new SpecificNote("gestion du temps",6,"L'employé peut améliorer sa gestion du temps pour respecter les délais des projets."),
                                new SpecificNote("collaboration",9,"L'employé a travaillé de manière collaborative avec les membres de son équipe"),
                                new SpecificNote("Compétences en test unitaire ",10,"L'employé a démontré d'excellentes compétences en test pénétration"))),
                                "Je recommande à l'employé de suivre une formation sur la gestion du temps pour renforcer ses compétences dans ce domaine.",
                                employees.get(new Random().nextInt(employees.size())).getId(),evaluationService.getAll().get(new Random().nextInt(evaluationService.getAll().size())), null)

                );
                scoreCardService.save(
                        new ScoreCard(null,ScoreCard.SpecificNote(Arrays.asList(
                                new SpecificNote("gestion du temps",9,"L'employé peut améliorer sa gestion du temps pour respecter les délais des projets."),
                                new SpecificNote("collaboration",5,"L'employé a travaillé de manière peu collaborative avec les membres de son équipe"),
                                new SpecificNote("Compétences en Pen testing",10,"L'employé a démontré d'excellentes compétences en test pénétration"))),
                                "Je recommande à l'employé de suivre une formation sur la l'intégration en entreprise.",
                                employees.get(new Random().nextInt(employees.size())).getId(),evaluationService.getAll().get(new Random().nextInt(evaluationService.getAll().size())), null

                        ));

                scoreCardService.save(
                        new ScoreCard(null,ScoreCard.SpecificNote(Arrays.asList(
                                new SpecificNote("gestion du temps",6,"L'employé peut améliorer sa gestion du temps pour respecter les délais des projets."),
                                new SpecificNote("collaboration",9,"L'employé a travaillé de manière collaborative avec les membres de son équipe"),
                                new SpecificNote("Compétences en Pen testing",10,"L'employé a démontré d'excellentes compétences en test pénétration"))),
                                "Je recommande à l'employé de suivre une formation sur la gestion du temps pour renforcer ses compétences dans ce domaine.",
                                employees.get(new Random().nextInt(employees.size())).getId(),evaluationService.getAll().get(new Random().nextInt(evaluationService.getAll().size())), null

                        ));
            }
        };
    }
}
