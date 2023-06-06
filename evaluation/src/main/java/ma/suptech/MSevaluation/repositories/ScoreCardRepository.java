package ma.suptech.MSevaluation.repositories;

import ma.suptech.MSevaluation.models.ScoreCard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScoreCardRepository extends JpaRepository<ScoreCard,Long> {
}
