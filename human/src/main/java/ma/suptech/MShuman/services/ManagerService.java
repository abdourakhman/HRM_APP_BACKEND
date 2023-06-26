package ma.suptech.MShuman.services;


import ma.suptech.MShuman.models.Employee;
import ma.suptech.MShuman.models.Manager;

import java.util.List;

public interface ManagerService {
    List<Manager> listManager();
    List<Employee> listEmployeeManager();
    List<Employee> findByJob(Long id);
    List<Employee>  findByDepartment(Long id);
    Employee findEmployeeManager(Long idEmployee);
    Manager findManager(Long idManager);
    Manager findManagerByRegistration(String registration);
    Employee save(Employee manager);
    Employee update(Employee manager);
    void delete(Long id);
}
