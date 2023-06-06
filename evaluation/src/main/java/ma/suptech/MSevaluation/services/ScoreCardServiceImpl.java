package ma.suptech.MSevaluation.services;


import ma.suptech.MSevaluation.client.HumanRestClient;
import ma.suptech.MSevaluation.models.ScoreCard;
import ma.suptech.MSevaluation.repositories.ScoreCardRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ScoreCardServiceImpl implements ScoreCardService {

    private final ScoreCardRepository scoreCardRepository;
    private final HumanRestClient humanRestClient;

    public ScoreCardServiceImpl(ScoreCardRepository scoreCardRepository, HumanRestClient humanRestClient){
        this.scoreCardRepository = scoreCardRepository;
        this.humanRestClient = humanRestClient;
    }
    @Override
    public ScoreCard save(ScoreCard scoreCard) {
        scoreCard.setEmployee(humanRestClient.findEmployee(scoreCard.getEmployeeID()));
        return scoreCardRepository.save(scoreCard);
    }

    @Override
    public ScoreCard update(ScoreCard scoreCard) {
        scoreCard.setEmployee(humanRestClient.findEmployee(scoreCard.getEmployeeID()));
        return scoreCardRepository.save(scoreCard);
    }

    @Override
    public ScoreCard find(Long id) {
        ScoreCard scoreCard = scoreCardRepository.findById(id).orElse(null);
        if(scoreCard != null)
            scoreCard.setEmployee(humanRestClient.findEmployee(scoreCard.getEmployeeID()));
        return scoreCard;
    }

    @Override
    public List<ScoreCard> getScoreCardEmployee(Long idEmployee) {
        return scoreCardRepository.findAll().stream()
                .filter(scoreCard -> scoreCard.getEmployeeID().equals(idEmployee))
                .map(scoreCard -> {
                    scoreCard.setEmployee(humanRestClient.findEmployee(scoreCard.getEmployeeID()));
                    return scoreCard;
                }).collect(Collectors.toList());
    }

    @Override
    public List<ScoreCard> getAll() {
        return scoreCardRepository.findAll().stream()
                .map(scoreCard -> {
                    scoreCard.setEmployee(humanRestClient.findEmployee(scoreCard.getEmployeeID()));
                    return scoreCard;
                }).collect(Collectors.toList());
    }

    @Override
    public void remove(Long id) {
        scoreCardRepository.deleteById(id);
    }
}
