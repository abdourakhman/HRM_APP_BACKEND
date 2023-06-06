package ma.suptech.MSemployee_evaluation.client;

import ma.suptech.MSemployee_evaluation.entities.Manager;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "RESPONSIBLE-SERVICE")
public interface ResponsibleRestClient {
    @GetMapping("/api/managers/{id}")
    Manager getManager(@PathVariable Long id);
}
