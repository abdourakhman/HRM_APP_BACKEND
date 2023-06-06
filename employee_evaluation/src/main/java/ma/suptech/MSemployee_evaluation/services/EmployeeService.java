package ma.suptech.MSemployee_evaluation.services;

import ma.suptech.MSemployee_evaluation.entities.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> listEmployee();
    List<Employee> findByJobID(Long id);
    List<Employee>  findByDepartmentID(Long id);
    List<Employee>  findByManagerID(Long id);
    Employee find(Long id);
    Employee save(Employee employee);
    Employee update(Employee employee);
    void delete(Long id);
}
