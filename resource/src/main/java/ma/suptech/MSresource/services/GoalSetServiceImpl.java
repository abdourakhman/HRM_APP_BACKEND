package ma.suptech.MSresource.services;

import ma.suptech.MSresource.client.HumanRestClient;
import ma.suptech.MSresource.models.GoalSet;
import ma.suptech.MSresource.repositories.GoalSetRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GoalSetServiceImpl implements GoalSetService {
    private final HumanRestClient humanRestClient;
    private final GoalSetRepository goalSetRepository;

    public GoalSetServiceImpl(HumanRestClient humanRestClient, GoalSetRepository goalSetRepository) {
        this.humanRestClient = humanRestClient;
        this.goalSetRepository = goalSetRepository;
    }

    @Override
    public GoalSet add(GoalSet goalSet) {
        goalSet.setEmployee(humanRestClient.findEmployee(goalSet.getEmployeeID()));
        return goalSetRepository.save(goalSet);
    }

    @Override
    public GoalSet update(GoalSet goalSet) {
        goalSet.setEmployee(humanRestClient.findEmployee(goalSet.getEmployeeID()));
        return goalSetRepository.save(goalSet);
    }

    @Override
    public GoalSet findOne(Long id) {
        GoalSet goalSet = goalSetRepository.findById(id).get();
        goalSet.setEmployee(humanRestClient.findEmployee(goalSet.getEmployeeID()));
        return goalSet;
    }

    @Override
    public List<GoalSet> findByProject(Long idProject) {
        return goalSetRepository.findAll().stream()
                .filter(goalSet -> goalSet.getProject().getId().equals(idProject))
                .map(goalSet -> {
                    goalSet.setEmployee(humanRestClient.findEmployee(goalSet.getEmployeeID()));
                    return goalSet;
                }).collect(Collectors.toList());
    }

    @Override
    public List<GoalSet> findByEmployee(Long idEmployee) {
        return goalSetRepository.findAll().stream()
                .filter(goalSet -> goalSet.getEmployeeID().equals(idEmployee))
                .map(goalSet -> {
                    goalSet.setEmployee(humanRestClient.findEmployee(goalSet.getEmployeeID()));
                    return goalSet;
                }).collect(Collectors.toList());
    }

    @Override
    public List<GoalSet> findAll() {
        return goalSetRepository.findAll().stream()
                .map(goalSet -> {
                    goalSet.setEmployee(humanRestClient.findEmployee(goalSet.getEmployeeID()));
                    return goalSet;
                }).collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
        goalSetRepository.deleteById(id);
    }
}
