package ma.suptech.MShuman.API;

import ma.suptech.MShuman.models.Employee;
import ma.suptech.MShuman.services.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class EmployeeAPI {
    private final EmployeeService employeeService;
    public EmployeeAPI(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    @GetMapping("employees")
    public List<Employee> listEmployee(){
        return employeeService.listEmployee();
    }


    @GetMapping("employees/department/{id}")
    public List<Employee> findEmployeeByDepartment(@PathVariable(name="id") Long id){
        return employeeService.findByDepartment(id);
    }

    @GetMapping("employees/job/{id}")
    public List<Employee> findEmployeeByJob(@PathVariable(name="id") Long id){
        return employeeService.findByJob(id);
    }

    @GetMapping("employees/manager/{id}")
    public List<Employee> findEmployeeByManager(@PathVariable(name="id") Long id){
        return employeeService.findByManager(id);
    }

    @GetMapping("employees/{id}")
    public Employee findEmployee(@PathVariable(name="id") Long id){
        return employeeService.find(id);
    }

    @PostMapping("employee")
    public Employee addEmployee(@RequestBody Employee employee){
        return employeeService.save(employee);
    }

    @PutMapping("employee")
    public Employee updateEmployee(@RequestBody Employee employee){
        return employeeService.update(employee);
    }

    @DeleteMapping("employee/{id}")
    public void removeEmployee(@PathVariable(name="id") Long id){
        employeeService.delete(id);
    }

    @GetMapping("numberOfEmployees/department")
    public Map<String,Integer> getNumberEmployeeByDepartment(){
        return employeeService.getNumberOfEmployeeByDepartment();
    }
    @GetMapping("numberOfEmployees")
    public Long getTotalEmployees(){
        return employeeService.getTotalEmployee();
    }
    @GetMapping("numberOfEmployees/active")
    public int getNumberOfActiveEmployees(){
        return employeeService.getNumberOfActiveWorker();
    }
    @GetMapping("numberOfEmployees/job")
    public Map<String,Integer> getNumberEmployeeByJob(){
        return employeeService.getNumberOfEmployeeByJob();
    }
    @GetMapping("numberOfEmployees/gender")
    public Map<String,Integer> getNumberEmployeeByGender(){
        return employeeService.getNumberOfEmployeeByGender();
    }
    @GetMapping("employees/average/age")
    public int getAverageAgeEmployees(){
        return employeeService.getAverageAge();
    }
}
