package ma.suptech.MSevaluation.services;

import ma.suptech.MSevaluation.models.Evaluation;

import java.util.List;

public interface EvaluationService {
    Evaluation save(Evaluation evaluation);
    Evaluation update(Evaluation evaluation);
    Evaluation find(Long id);
    List<Evaluation> getAll();
    void remove(Long id);
}
