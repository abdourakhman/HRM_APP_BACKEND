package ma.suptech.MSemployee_evaluation.repositories;


import ma.suptech.MSemployee_evaluation.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {

}
