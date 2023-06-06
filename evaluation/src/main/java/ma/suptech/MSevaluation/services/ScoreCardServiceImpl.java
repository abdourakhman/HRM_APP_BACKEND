package ma.suptech.MSevaluation.services;


import ma.suptech.MSevaluation.models.Evaluation;
import ma.suptech.MSevaluation.repositories.EvaluationRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EvaluationServiceImpl implements EvaluationService {

    private final EvaluationRepository evaluationRepository;

    public EvaluationServiceImpl(EvaluationRepository evaluationRepository){
        this.evaluationRepository = evaluationRepository;
    }
    @Override
    public Evaluation save(Evaluation evaluation) {
        return evaluationRepository.save(evaluation);
    }

    @Override
    public Evaluation update(Evaluation evaluation) {
        return evaluationRepository.save(evaluation);
    }

    @Override
    public Evaluation find(Long id) {
        return evaluationRepository.findById(id).orElse(null);
    }

    @Override
    public List<Evaluation> getAll() {
        List<Evaluation> evaluations = new ArrayList<>();
        evaluationRepository.findAll().forEach(evaluation -> evaluations.add(evaluation));
        return evaluations;
    }

    @Override
    public void remove(Long id) {
        evaluationRepository.deleteById(id);
    }
}
