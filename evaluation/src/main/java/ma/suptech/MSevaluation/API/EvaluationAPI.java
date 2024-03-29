package ma.suptech.MSevaluation.API;

import ma.suptech.MSevaluation.models.Evaluation;
import ma.suptech.MSevaluation.services.EvaluationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EvaluationAPI {

    private final EvaluationService evaluationService;

    public EvaluationAPI(EvaluationService evaluationService) {
        this.evaluationService = evaluationService;
    }

    @PostMapping("/evaluation")
    public Evaluation save(@RequestBody Evaluation evaluation){
        return evaluationService.save(evaluation);
    }
    @PutMapping("/evaluation")
    public Evaluation update(@RequestBody Evaluation evaluation){
        return evaluationService.update(evaluation);
    }
    @GetMapping("evaluations/{id}")
    public Evaluation find(@PathVariable Long id){
        return evaluationService.find(id);
    }

    @GetMapping("/evaluations")
    public List<Evaluation> list(){
        return evaluationService.getAll();
    }
    @DeleteMapping("/evaluation/{id}")
    public void remove(@PathVariable Long id){
        evaluationService.remove(id);
    }

}
