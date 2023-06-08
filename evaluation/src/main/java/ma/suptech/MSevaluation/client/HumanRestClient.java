package ma.suptech.MSevaluation.client;


import ma.suptech.MSevaluation.models.helper.Employee;
import ma.suptech.MSevaluation.models.helper.Manager;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "HUMAN-MANAGEMENT-SERVICE")
public interface HumanRestClient {
    @GetMapping("api/employees/{idEmployee}")
    Employee findEmployee(@PathVariable Long idEmployee);
    @GetMapping("api/employees")
    List<Employee> listEmployee();

    @GetMapping("api/managers/{idManager}")
    Manager findManager(@PathVariable Long idManager);

    @GetMapping("api/employees/managers/{idEmployee}")
    Employee findEmployeeManager(@PathVariable Long idEmployee);
    @GetMapping("api/managers")
    List<Manager> listManager();

    @GetMapping("api/employees/managers")
    List<Employee> listEmployeeManager();


}
