package ma.suptech.MShuman.API;

import ma.suptech.MShuman.models.Employee;
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
        return humanResourceManagerService.listRh();
    }

    @GetMapping("employees/humanResourceManagers")
    public List<Employee> listEmployeeHumanResourceManager(){
        return humanResourceManagerService.listEmployeeRH();
    }


    @GetMapping("humanResourceManagers/department/{id}")
    public List<Employee> findHumanResourceManagerByDepartment(@PathVariable(name="id") Long id){
        return humanResourceManagerService.findByDepartment(id);
    }

    @GetMapping("humanResourceManagers/{id}")
    public Employee findEmployeeRh(@PathVariable(name="id") Long id){
        return humanResourceManagerService.findEmployeeRh(id);
    }
    @GetMapping("employees/humanResourceManagers/{id}")
    public HumanResourceManager findRh(@PathVariable(name="id") Long id){
        return humanResourceManagerService.findRh(id);
    }

    @PostMapping("humanResourceManager")
    public Employee addManager(@RequestBody Employee humanResourceManager){
        return humanResourceManagerService.save(humanResourceManager);
    }

    @PutMapping("humanResourceManager")
    public Employee updateManager(@RequestBody Employee humanResourceManager){
        return humanResourceManagerService.update(humanResourceManager);
    }

    @DeleteMapping("humanResourceManager/{id}")
    public void removeManager(@PathVariable(name="id") Long id){
        humanResourceManagerService.delete(id);
    }
}
