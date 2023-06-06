package ma.suptech.MShuman.API;

import ma.suptech.MShuman.models.HumanResourceManager;
import ma.suptech.MShuman.services.HumanResourceManagerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class HumanResourceManagerAPI {
    private final HumanResourceManagerService humanResourceManagerService;
    public HumanResourceManagerAPI(HumanResourceManagerService humanResourceManagerService){
        this.humanResourceManagerService = humanResourceManagerService;
    }

    @GetMapping("humanResourceManagers")
    public List<HumanResourceManager> listHumanResourceManager(){
        return humanResourceManagerService.listRH();
    }


    @GetMapping("humanResourceManagers/department/{id}")
    public List<HumanResourceManager> findHumanResourceManagerByDepartment(@PathVariable(name="id") Long id){
        return humanResourceManagerService.findByDepartment(id);
    }



    @GetMapping("humanResourceManagers/{id}")
    public HumanResourceManager findManager(@PathVariable(name="id") Long id){
        return humanResourceManagerService.find(id);
    }

    @PostMapping("humanResourceManager")
    public HumanResourceManager addManager(@RequestBody HumanResourceManager humanResourceManager){
        return humanResourceManagerService.save(humanResourceManager);
    }

    @PutMapping("humanResourceManager")
    public HumanResourceManager updateManager(@RequestBody HumanResourceManager humanResourceManager){
        return humanResourceManagerService.update(humanResourceManager);
    }

    @DeleteMapping("humanResourceManager/{id}")
    public void removeManager(@PathVariable(name="id") Long id){
        humanResourceManagerService.delete(id);
    }
}
