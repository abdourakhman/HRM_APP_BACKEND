package ma.suptech.MShuman.services;


import ma.suptech.MShuman.models.Employee;

import java.util.List;

public interface ManagerService {

    List<Employee> listManager();
    List<Employee> findByJob(Long id);
    List<Employee>  findByDepartment(Long id);
    Employee find(Long id);
    Employee save(Employee manager);
    Employee update(Employee manager);
    void delete(Long id);
}
