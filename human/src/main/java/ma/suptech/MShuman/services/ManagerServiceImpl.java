package ma.suptech.MShuman.services;

import ma.suptech.MShuman.client.OrganizationRestClient;
import ma.suptech.MShuman.models.Employee;
import ma.suptech.MShuman.models.Manager;
import ma.suptech.MShuman.repositories.EmployeeRepository;
import ma.suptech.MShuman.repositories.ManagerRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Collectors;

@Service
public class ManagerServiceImpl implements ManagerService {
    private final ManagerRepository managerRepository;
    private final EmployeeRepository employeeRepository;
    private final OrganizationRestClient organizationRestClient;


    public ManagerServiceImpl(ManagerRepository managerRepository, EmployeeRepository employeeRepository, OrganizationRestClient organizationRestClient){
        this.managerRepository = managerRepository;
        this.employeeRepository = employeeRepository;
        this.organizationRestClient = organizationRestClient;
    }

    @Override
    public List<Employee> listManager() {
        List<Employee> managers = new ArrayList<>();
        employeeRepository.findAll().forEach(employee -> {
            for(Manager manager: managerRepository.findAll()){
                if(employee.getRegistrationNumber().equals(manager.getRegistrationNumber())){
                    employee.setJob(organizationRestClient.findByJob(employee.getJobID()));
                    employee.setDepartment(organizationRestClient.findByDepartment(employee.getDepartmentID()));
                    managers.add(employee);
                }
            }
        });
        return managers;
    }


    @Override
    public Employee find(Long id) {
        AtomicBoolean isExist = new AtomicBoolean(false);
        Employee manager = employeeRepository.findById(id).orElse(null);
        if(manager != null){
            managerRepository.findAll().forEach(manager1 ->{
                if(manager1.getRegistrationNumber().equals(manager.getRegistrationNumber())){
                    manager.setJob(organizationRestClient.findByJob(manager.getJobID()));
                    manager.setDepartment(organizationRestClient.findByDepartment(manager.getDepartmentID()));
                    isExist.set(true);
                }
            });
        }
        if(isExist.get())
            return manager;
        return null;
    }

    @Override
    public Employee save(Employee employee) {
        String registrationNumber = UUID.randomUUID().toString();
        managerRepository.save(new Manager(null,registrationNumber,null));
        employee.setJob(organizationRestClient.findByJob(employee.getJobID()));
        employee.setDepartment(organizationRestClient.findByDepartment(employee.getDepartmentID()));

        return employeeRepository.save(employee);
    }

    @Override
    public Employee update(Employee employee) {
        employee.setJob(organizationRestClient.findByJob(employee.getJobID()));
        employee.setDepartment(organizationRestClient.findByDepartment(employee.getDepartmentID()));
        return employeeRepository.save(employee);
    }

    @Override
    public void delete(Long id) {
        Employee employee = employeeRepository.findById(id).get();
        Manager manager = managerRepository.findAll().stream().filter(manager1 -> manager1.getRegistrationNumber().equals(employee.getRegistrationNumber())).findAny().get();
        employeeRepository.delete(employee);
        managerRepository.delete(manager);    }

    @Override
    public List<Employee> findByJob(Long id) {
        List<Employee> managers  = new ArrayList<>();
        employeeRepository.findAll().forEach(employee -> {
            for (Manager manager : managerRepository.findAll()) {
                if (manager.getRegistrationNumber().equals(employee.getRegistrationNumber()))
                    if (employee.getJobID().equals(id)) {
                        employee.setJob(organizationRestClient.findByJob(id));
                        employee.setDepartment(organizationRestClient.findByDepartment(employee.getDepartmentID()));
                        managers.add(employee);
                    }
            }
        });
        return managers;
    }

    @Override
    public List<Employee>  findByDepartment(Long id) {
        List<Employee> managers = new ArrayList<>();
        employeeRepository.findAll().forEach(employee -> {
            for(Manager manager: managerRepository.findAll()){
                if(employee.getRegistrationNumber().equals(manager.getRegistrationNumber()))
                    if(employee.getDepartmentID().equals(id)){
                        employee.setJob(organizationRestClient.findByJob(id));
                        employee.setDepartment(organizationRestClient.findByDepartment(employee.getDepartmentID()));
                        managers.add(employee);
                    }
            }
        });
        return managers;
    }


}
