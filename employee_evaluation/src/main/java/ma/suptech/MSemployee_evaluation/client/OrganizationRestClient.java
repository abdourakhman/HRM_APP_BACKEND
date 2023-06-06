package ma.suptech.MSemployee_evaluation.client;

import ma.suptech.MSemployee_evaluation.entities.Department;
import ma.suptech.MSemployee_evaluation.entities.Job;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name="ORGANIZATION-SERVICE")
public interface OrganizationRestClient {

    @GetMapping("api/departments/{id}")
    Department findByDepartment(@PathVariable Long id);

    @GetMapping("api/jobs/{id}")
    Job findByJob(@PathVariable Long id);

}
