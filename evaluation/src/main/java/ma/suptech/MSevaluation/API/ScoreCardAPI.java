package ma.suptech.MSevaluation.API;

import ma.suptech.MSevaluation.models.ScoreCard;
import ma.suptech.MSevaluation.services.ScoreCardService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ScoreCardAPI {

    private final ScoreCardService scoreCardService;

    public ScoreCardAPI(ScoreCardService scoreCardService) {
        this.scoreCardService = scoreCardService;
    }

    @PostMapping("/scoreCard")
    public ScoreCard save(@RequestBody ScoreCard scoreCard){
        return scoreCardService.save(scoreCard);
    }
    @PutMapping("/scoreCard")
    public ScoreCard update(@RequestBody ScoreCard scoreCard){
        return scoreCardService.update(scoreCard);
    }
    @GetMapping("scoreCards/{id}")
    public ScoreCard find(@PathVariable Long id){
        return scoreCardService.find(id);
    }

    @GetMapping("/scoreCards/employee/{idEmployee}")
    public List<ScoreCard> listScoreCardEmployee(@PathVariable Long idEmployee){
        return scoreCardService.getScoreCardEmployee(idEmployee);
    }

    @GetMapping("/scoreCards")
    public List<ScoreCard> list(){
        return scoreCardService.getAll();
    }
    @DeleteMapping("/scoreCard/{id}")
    public void remove(@PathVariable Long id){
        scoreCardService.remove(id);
    }

}
