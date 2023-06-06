package ma.suptech.MSevaluation.config;

import lombok.AllArgsConstructor;
import ma.suptech.MSevaluation.models.Evaluation;
import ma.suptech.MSevaluation.models.ScoreCard;
import ma.suptech.MSevaluation.models.helper.SpecificNote;
import ma.suptech.MSevaluation.services.EvaluationService;
import ma.suptech.MSevaluation.services.ScoreCardService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.Arrays;

@Configuration
@AllArgsConstructor
public class EvaluationConfig {
    private final EvaluationService evaluationService;
    private final ScoreCardService scoreCardService;

    @Bean
    CommandLineRunner initEvaluation(){
        return  args -> {
            Evaluation evaluation = evaluationService.save(new Evaluation(null,LocalDate.of(2023,6,11),"L'objectif principal était d'augmenter le rendement de l'équpe dev de 10% ce trimestre.",null));
            ScoreCard sc1 = scoreCardService.save(
                    new ScoreCard(null,ScoreCard.SpecificNote(Arrays.asList(
                    new SpecificNote("gestion du temps",6,"L'employé peut améliorer sa gestion du temps pour respecter les délais des projets."),
                    new SpecificNote("collaboration",9,"L'employé a travaillé de manière collaborative avec les membres de son équipe"),
                    new SpecificNote("Compétences en test unitaire ",10,"L'employé a démontré d'excellentes compétences en test pénétration"))),
                    "Je recommande à l'employé de suivre une formation sur la gestion du temps pour renforcer ses compétences dans ce domaine.",
                    1L,null, null

            ));
            ScoreCard sc2 = scoreCardService.save(
                    new ScoreCard(null,ScoreCard.SpecificNote(Arrays.asList(
                            new SpecificNote("gestion du temps",9,"L'employé peut améliorer sa gestion du temps pour respecter les délais des projets."),
                            new SpecificNote("collaboration",5,"L'employé a travaillé de manière peu collaborative avec les membres de son équipe"),
                            new SpecificNote("Compétences en Pen testing",10,"L'employé a démontré d'excellentes compétences en test pénétration"))),
                            "Je recommande à l'employé de suivre une formation sur la l'intégration en entreprise.",
                            2L,null, null

                    ));

            ScoreCard sc3 = scoreCardService.save(
                    new ScoreCard(null,ScoreCard.SpecificNote(Arrays.asList(
                            new SpecificNote("gestion du temps",6,"L'employé peut améliorer sa gestion du temps pour respecter les délais des projets."),
                            new SpecificNote("collaboration",9,"L'employé a travaillé de manière collaborative avec les membres de son équipe"),
                            new SpecificNote("Compétences en Pen testing",10,"L'employé a démontré d'excellentes compétences en test pénétration"))),
                            "Je recommande à l'employé de suivre une formation sur la gestion du temps pour renforcer ses compétences dans ce domaine.",
                            3L,null, null

                    ));
        };
    }
}
