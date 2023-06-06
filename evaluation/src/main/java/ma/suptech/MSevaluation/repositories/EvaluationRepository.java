package ma.suptech.MSevaluation.repositories;

import ma.suptech.MSevaluation.models.Evaluation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EvaluationRepository extends JpaRepository<Evaluation,Long> {
}
