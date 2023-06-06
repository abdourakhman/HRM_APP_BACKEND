package ma.suptech.MSevaluation.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Collection;

@Data @Entity
@NoArgsConstructor @AllArgsConstructor
public class Evaluation {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private LocalDate evaluationDate;
    private String goalSet; //objective
    @OneToMany(mappedBy = "evaluation")
    private Collection<ScoreCard> scoreCards;
}
