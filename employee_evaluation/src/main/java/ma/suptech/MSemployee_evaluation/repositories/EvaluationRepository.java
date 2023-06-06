package ma.suptech.MSemployee_evaluation.repositories;

import ma.suptech.MSemployee_evaluation.entities.Evaluation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface EvaluationRepository extends JpaRepository<Evaluation,Long> {
}
