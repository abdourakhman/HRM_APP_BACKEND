package ma.suptech.MShuman.API;

import ma.suptech.MShuman.models.Employee;
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
    public List<Employee> listManager(){
        return managerService.listManager();
    }


    @GetMapping("managers/department/{id}")
    public List<Employee> findManagerByDepartment(@PathVariable(name="id") Long id){
        return managerService.findByDepartment(id);
    }

    @GetMapping("managers/job/{id}")
    public List<Employee> findManagerByJob(@PathVariable(name="id") Long id){
        return managerService.findByJob(id);
    }


    @GetMapping("managers/{id}")
    public Employee findManager(@PathVariable(name="id") Long id){
        return managerService.find(id);
    }

    @PostMapping("manager")
    public Employee addManager(@RequestBody Employee manager){
        return managerService.save(manager);
    }

    @PutMapping("manager")
    public Employee updateManager(@RequestBody Employee manager){
        return managerService.update(manager);
    }

    @DeleteMapping("manager/{id}")
    public void removeManager(@PathVariable(name="id") Long id){
        managerService.delete(id);
    }
}
