package ma.suptech.MShuman.services;



import ma.suptech.MShuman.models.Employee;

import java.util.List;

public interface HumanResourceManagerService {

    List<Employee> listRH();
    List<Employee>  findByDepartment(Long id);
    Employee find(Long id);
    Employee save(Employee employee);
    Employee update(Employee employee);
    void delete(Long id);
}
