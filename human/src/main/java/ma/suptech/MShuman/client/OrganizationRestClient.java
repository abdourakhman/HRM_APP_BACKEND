package ma.suptech.MShuman.client;

import ma.suptech.MShuman.models.help.Department;
import ma.suptech.MShuman.models.help.Job;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;


@FeignClient(name="ORGANIZATION-SERVICE")
public interface OrganizationRestClient {

    @GetMapping("api/departments/{id}")
    Department findByDepartment(@PathVariable Long id);

    @GetMapping("api/departments")
    List<Department> listDepartment();

    @GetMapping("api/jobs")
    List<Job> listJob();

    @GetMapping("api/jobs/{id}")
    Job findByJob(@PathVariable Long id);

}
