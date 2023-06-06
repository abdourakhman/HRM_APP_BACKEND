package ma.suptech.MSresource.API;

import ma.suptech.MSresource.models.Project;
import ma.suptech.MSresource.services.ProjectService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/")
public class ProjectAPI {
    private final ProjectService projectService;

    public ProjectAPI(ProjectService projectService) {
        this.projectService = projectService;
    }
    @PostMapping("project/")
    public Project addProject(@RequestBody Project project){
        return projectService.add(project);
    }

    @PutMapping("project/")
    public Project updateProject(@RequestBody Project project){
        return projectService.update(project);
    }

    @GetMapping("projects/{id}")
        public Project findProject(@PathVariable Long  id){
        return projectService.findOne(id);
    }

    @GetMapping("projects/")
    public List<Project> listProject(){
        return projectService.findAll();
    }

    @GetMapping("projects/manager/{idManager}")
    public List<Project> listProjectManager(@PathVariable Long idManager){
        return projectService.findByManager(idManager);
    }

    @GetMapping("projects/{id}")
    public void deleteProject(@PathVariable Long id){
        projectService.delete(id);
    }



}
