package ma.suptech.MSresource.services;

import ma.suptech.MSresource.models.GoalSet;

import java.util.List;

public interface GoalSetService {
    GoalSet add (GoalSet goalSet);
    GoalSet update (GoalSet goalSet);
    GoalSet findOne (Long id);
    List<GoalSet> findByProject (Long  idProject);
    List<GoalSet> findByEmployee (Long  idEmployee);
    List<GoalSet> findAll ();

    void delete(Long id );
}
