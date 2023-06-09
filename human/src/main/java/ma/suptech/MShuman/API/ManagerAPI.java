package ma.suptech.MShuman.API;

import ma.suptech.MShuman.models.Employee;
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
    @GetMapping("employees/managers")
    public List<Employee> listEmployeeManager(){
        return managerService.listEmployeeManager();
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
    public Manager findManager(@PathVariable(name="id") Long id){
        return managerService.findManager(id);
    }

    @GetMapping("employees/managers/{id}")
    public Employee findEmployeeManager(@PathVariable(name="id") Long id){
        return managerService.findEmployeeManager(id);
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
