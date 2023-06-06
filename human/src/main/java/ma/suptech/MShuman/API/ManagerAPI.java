package ma.suptech.MShuman.API;

import ma.suptech.MShuman.models.Manager;
import ma.suptech.MShuman.services.ManagerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ManagerAPI {
    private final ManagerService managerService;
    public ManagerAPI(ManagerService managerService){
        this.managerService = managerService;
    }

    @GetMapping("managers")
    public List<Manager> listManager(){
        return managerService.listManager();
    }


    @GetMapping("managers/department/{id}")
    public List<Manager> findManagerByDepartment(@PathVariable(name="id") Long id){
        return managerService.findByDepartment(id);
    }

    @GetMapping("managers/job/{id}")
    public List<Manager> findManagerByJob(@PathVariable(name="id") Long id){
        return managerService.findByJob(id);
    }


    @GetMapping("managers/{id}")
    public Manager findManager(@PathVariable(name="id") Long id){
        return managerService.find(id);
    }

    @PostMapping("manager")
    public Manager addManager(@RequestBody Manager manager){
        return managerService.save(manager);
    }

    @PutMapping("manager")
    public Manager updateManager(@RequestBody Manager manager){
        return managerService.update(manager);
    }

    @DeleteMapping("manager/{id}")
    public void removeManager(@PathVariable(name="id") Long id){
        managerService.delete(id);
    }
}
