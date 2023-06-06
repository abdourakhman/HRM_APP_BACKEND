package ma.suptech.MShuman.services;

import ma.suptech.MShuman.client.OrganizationRestClient;
import ma.suptech.MShuman.models.Employee;
import ma.suptech.MShuman.models.help.Department;
import ma.suptech.MShuman.models.help.Job;
import ma.suptech.MShuman.repositories.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final OrganizationRestClient organizationRestClient;


    public EmployeeServiceImpl(EmployeeRepository employeeRepository, OrganizationRestClient organizationRestClient){
        this.employeeRepository = employeeRepository;
        this.organizationRestClient = organizationRestClient;
    }

    @Override
    public List<Employee> listEmployee() {
        List<Employee> employees = new ArrayList<>();
        employeeRepository.findAll().forEach(employee -> {
            employee.setJob(organizationRestClient.findByJob(employee.getJobID()));
            employee.setDepartment(organizationRestClient.findByDepartment(employee.getDepartmentID()));
            employees.add(employee);
        });
        return employees;
    }


    @Override
    public Employee find(Long id) {
        Employee employee = employeeRepository.findById(id).orElse(null);
        if(employee != null){
            employee.setJob(organizationRestClient.findByJob(employee.getJobID()));
            employee.setDepartment(organizationRestClient.findByDepartment(employee.getDepartmentID()));
        }
        return employee;
    }

    @Override
    public Employee save(Employee employee) {
        Employee employeeSaved = employeeRepository.save(employee);
        employeeSaved.setJob(organizationRestClient.findByJob(employee.getJobID()));
        employeeSaved.setDepartment(organizationRestClient.findByDepartment(employee.getDepartmentID()));
        return employeeSaved;
    }

    @Override
    public Employee update(Employee employee) {
        Employee employeeUpdated = employeeRepository.save(employee);
        employeeUpdated.setJob(organizationRestClient.findByJob(employee.getJobID()));
        employeeUpdated.setDepartment(organizationRestClient.findByDepartment(employee.getDepartmentID()));
        return employeeUpdated;
    }

    @Override
    public void delete(Long id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public List<Employee> findByJob(Long id) {
        Job job = organizationRestClient.findByJob(id);
        List<Employee> employees ;
        employees = employeeRepository.findAll().stream().filter(employee -> job.getId()==employee.getJobID()).toList();
        employees.forEach(employee -> {employee.setJob(job);
            employee.setDepartment(organizationRestClient.findByDepartment(employee.getDepartmentID()));});
        return employees;
    }

    @Override
    public List<Employee>  findByDepartment(Long id) {
        Department department = organizationRestClient.findByDepartment(id);
        List<Employee> employees;
        employees = employeeRepository.findAll().stream().filter(employee -> department.getId()==employee.getDepartmentID()).toList();
        employees.forEach(employee -> {employee.setDepartment(department);
            employee.setJob(organizationRestClient.findByJob(employee.getJobID()));
        });
        return employees;
    }

    @Override
    public List<Employee> findByManager(Long id) {
        List<Employee> employees;
        employees = employeeRepository.findAll().stream().filter(employee -> employee.getManager().getId().equals(id)).toList();
        employees.forEach(employee -> {
            employee.setJob(organizationRestClient.findByJob(employee.getJobID()));
            employee.setDepartment(organizationRestClient.findByDepartment(employee.getDepartmentID()));
        });
        return employees;
    }

}
