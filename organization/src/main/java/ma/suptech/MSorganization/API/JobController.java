package ma.suptech.MSorganization.API;

import ma.suptech.MSorganization.entities.Job;
import ma.suptech.MSorganization.services.JobService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class JobController {

    private final JobService jobService;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }
    @PostMapping("/job")
    @CrossOrigin(origins = "http://localhost:4200")
    public Job create(@RequestBody Job job){
        return jobService.create(job);
    }

    @PutMapping("/job")
    public Job update(@RequestBody Job job){
        return jobService.update(job);
    }

    @GetMapping("/jobs/{id}")
    public Job find(@PathVariable Long id ){
        return jobService.find(id);
    }

    @GetMapping("/jobs")
    public List<Job> findAll(){
        return jobService.list();
    }

    @DeleteMapping("/job/{id}")
    public void delete(@PathVariable Long id ){
        jobService.delete(id);
    }
}
