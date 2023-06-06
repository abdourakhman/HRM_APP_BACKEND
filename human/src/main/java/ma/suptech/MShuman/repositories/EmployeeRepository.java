package ma.suptech.MShuman.repositories;


import ma.suptech.MShuman.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {

}
