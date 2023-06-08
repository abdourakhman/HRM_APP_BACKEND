package ma.suptech.MSresource.client;

import ma.suptech.MSresource.models.helper.Employee;
import ma.suptech.MSresource.models.helper.HumanResourceManager;
import ma.suptech.MSresource.models.helper.Manager;
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

    @GetMapping("api/humanResourceManagers/{idRH}")
    HumanResourceManager findHumanResourceManager(@PathVariable Long idRH);
    @GetMapping("api/employees/humanResourceManagers/{idEmployee}")
    Employee findEmployeeRh(@PathVariable Long idEmployee);
    @GetMapping("api/employees/humanResourceManagers")
    List<Employee> listEmployeeRh();

    @GetMapping("api/humanResourceManagers")
    List<HumanResourceManager> listRh();
}
