package ma.suptech.MSresource.client;

import ma.suptech.MSresource.models.helper.Employee;
import ma.suptech.MSresource.models.helper.HumanResourceManager;
import ma.suptech.MSresource.models.helper.Manager;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "HUMAN-MANAGEMENT-SERVICE")
public interface HumanRestClient {
    @GetMapping("api/employees/{idEmployee}")
    Employee findEmployee(@PathVariable Long idEmployee);

    @GetMapping("api/managers/{idManager}")
    Manager findManager(@PathVariable Long idManager);

    @GetMapping("api/humanResourceManagers/{idRH}")
    HumanResourceManager findHumanResourceManager(@PathVariable Long idRH);
}
