package ma.suptech.MSorganization.repositories;

import ma.suptech.MSorganization.entities.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department,Long> {
}
