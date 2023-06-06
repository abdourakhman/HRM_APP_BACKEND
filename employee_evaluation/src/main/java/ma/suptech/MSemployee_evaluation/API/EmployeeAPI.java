package ma.suptech.MSemployee_evaluation.API;

import ma.suptech.MSemployee_evaluation.entities.Employee;
import ma.suptech.MSemployee_evaluation.services.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/hr")
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
        return employeeService.findByDepartmentID(id);
    }

    @GetMapping("employees/job/{id}")
    public List<Employee> findEmployeeByJob(@PathVariable(name="id") Long id){
        return employeeService.findByJobID(id);
    }

    @GetMapping("employees/manager/{id}")
    public List<Employee> findEmployeeByManager(@PathVariable(name="id") Long id){
        return employeeService.findByManagerID(id);
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
}
