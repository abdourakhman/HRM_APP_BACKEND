package ma.suptech.MSevaluation.services;

import ma.suptech.MSevaluation.models.ScoreCard;

import java.util.List;

public interface ScoreCardService {
    ScoreCard save(ScoreCard scoreCard);
    ScoreCard update(ScoreCard scoreCard);
    ScoreCard find(Long id);
    List<ScoreCard> getScoreCardEmployee(Long idEmployee);
    List<ScoreCard> getAll();
    void remove(Long id);
}
