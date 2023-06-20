package ma.suptech.MShuman.services;


import ma.suptech.MShuman.models.Employee;

import java.util.List;
import java.util.Map;

public interface EmployeeService {

    List<Employee> listEmployee();
    List<Employee> findByJob(Long id);
    List<Employee>  findByDepartment(Long id);
    List<Employee>  findByManager(Long id);
    Map<String,Integer> getNumberOfEmployeeByJob();
    Map<String,Integer> getNumberOfEmployeeByDepartment();
    Map<String,Integer> getNumberOfEmployeeByGender();
    Long getTotalEmployee();
    int getNumberOfActiveWorker();
    int getAverageAge();
    Employee find(Long id);
    Employee findEmployeeByRegistrationNumber(String registrationNumber);
    Employee save(Employee employee);
    Employee update(Employee employee);
    void delete(Long id);
}
