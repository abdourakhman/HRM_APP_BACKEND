package ma.suptech.MSemployee_evaluation.services;

import ma.suptech.MSemployee_evaluation.entities.Evaluation;

import java.util.List;

public interface EvaluationService {
    Evaluation save(Evaluation evaluation);
    Evaluation update(Evaluation evaluation);
    Evaluation find(Long id);
    List<Evaluation>getAll();
    void remove(Long id);
}
