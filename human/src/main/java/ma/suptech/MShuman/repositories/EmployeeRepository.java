package ma.suptech.MShuman.repositories;


import ma.suptech.MShuman.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {

}
