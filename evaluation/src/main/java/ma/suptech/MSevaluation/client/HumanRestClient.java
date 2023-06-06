package ma.suptech.MSevaluation.client;


import ma.suptech.MSevaluation.models.helper.Employee;
import ma.suptech.MSevaluation.models.helper.Manager;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "HUMAN-MANAGEMENT-SERVICE")
public interface HumanRestClient {
    @GetMapping("api/employees/{idEmployee}")
    Employee findEmployee(@PathVariable Long idEmployee);

    @GetMapping("api/managers/{idManager}")
    Manager findManager(@PathVariable Long idManager);

}
