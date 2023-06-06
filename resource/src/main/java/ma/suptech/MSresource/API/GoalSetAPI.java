package ma.suptech.MSresource.API;

import ma.suptech.MSresource.models.GoalSet;
import ma.suptech.MSresource.services.GoalSetService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/")
public class GoalSetAPI {
    private final GoalSetService goalSetService;

    public GoalSetAPI(GoalSetService goalSetService) {
        this.goalSetService = goalSetService;
    }
    @PostMapping("goalSet/")
    public GoalSet addGoalSet(@RequestBody GoalSet goalSet){
        return goalSetService.add(goalSet);
    }

    @PutMapping("goalSet/")
    public GoalSet updateGoalSet(@RequestBody GoalSet goalSet){
        return goalSetService.update(goalSet);
    }

    @GetMapping("projects/{id}")
        public GoalSet findGoalSet(@PathVariable Long  id){
        return goalSetService.findOne(id);
    }

    @GetMapping("projects/")
    public List<GoalSet> listGoalSet(){
        return goalSetService.findAll();
    }

    @GetMapping("projects/employee/{idEmployee}")
    public List<GoalSet> listGoalsetEmployee(@PathVariable Long idEmployee){
        return goalSetService.findByEmployee(idEmployee);
    }

    @GetMapping("projects/{id}")
    public void deleteProject(@PathVariable Long id){
        goalSetService.delete(id);
    }
}
