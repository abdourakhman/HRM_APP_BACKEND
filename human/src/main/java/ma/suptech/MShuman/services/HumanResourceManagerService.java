package ma.suptech.MShuman.services;



import ma.suptech.MShuman.models.Employee;
import ma.suptech.MShuman.models.HumanResourceManager;

import java.util.List;

public interface HumanResourceManagerService {

    List<HumanResourceManager> listRh();
    List<Employee> listEmployeeRH();
    List<Employee>  findByDepartment(Long id);
    HumanResourceManager findRh(Long idRh);
    Employee findEmployeeRh(Long idEmployee);
    Employee save(Employee employee);
    Employee update(Employee employee);
    void delete(Long id);
}
