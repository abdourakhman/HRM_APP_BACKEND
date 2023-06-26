package ma.suptech.MShuman.services;

import ma.suptech.MShuman.client.OrganizationRestClient;
import ma.suptech.MShuman.models.Employee;
import ma.suptech.MShuman.models.HumanResourceManager;
import ma.suptech.MShuman.repositories.EmployeeRepository;
import ma.suptech.MShuman.repositories.HumanResourceManagerRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;


@Service
public class HumanResourceManagerServiceImpl implements HumanResourceManagerService {
    private final HumanResourceManagerRepository humanResourceManagerRepository;
    private final EmployeeRepository employeeRepository;
    private final OrganizationRestClient organizationRestClient;


    public HumanResourceManagerServiceImpl(HumanResourceManagerRepository humanResourceManagerRepository, EmployeeRepository employeeRepository, OrganizationRestClient organizationRestClient){
        this.humanResourceManagerRepository = humanResourceManagerRepository;
        this.employeeRepository = employeeRepository;
        this.organizationRestClient = organizationRestClient;
    }

    @Override
    public List<HumanResourceManager> listRh() {
        return humanResourceManagerRepository.findAll();
    }

    @Override
    public List<Employee> listEmployeeRH() {
        List<Employee> humanResourceManagers = new ArrayList<>();
        employeeRepository.findAll()
                .forEach(employee -> {
                    for (HumanResourceManager rh : humanResourceManagerRepository.findAll()){
                        if(rh.getRegistrationNumber().equals(employee.getRegistrationNumber())){
                            employee.setJob(organizationRestClient.findByJob(employee.getJobID()));
                            employee.setDepartment(organizationRestClient.findByDepartment(employee.getDepartmentID()));
                            humanResourceManagers.add(employee);
                        }
                    }
                });
        return humanResourceManagers;
    }


    @Override
    public Employee findEmployeeRh(Long id) {
        AtomicBoolean isExist = new AtomicBoolean(false);
        Employee humanResourceManager = employeeRepository.findById(id).orElse(null);
        if(humanResourceManager != null){
            humanResourceManagerRepository.findAll().forEach(rh ->{
                if(rh.getRegistrationNumber().equals(humanResourceManager.getRegistrationNumber())){
                    humanResourceManager.setJob(organizationRestClient.findByJob(humanResourceManager.getJobID()));
                    humanResourceManager.setDepartment(organizationRestClient.findByDepartment(humanResourceManager.getDepartmentID()));
                    isExist.set(true);
                }
            });
        }
        if(isExist.get())
            return humanResourceManager;
        return null;
    }

    @Override
    public Employee save(Employee employee) {
        String registrationNumber = UUID.randomUUID().toString();
        humanResourceManagerRepository.save(new HumanResourceManager(null,registrationNumber));
        employee.setRegistrationNumber(registrationNumber);
        employee.setJob(organizationRestClient.findByJob(15L)); //rh job
        employee.setDepartment(organizationRestClient.findByDepartment(15L)); //Department RH
        return employeeRepository.save(employee);
    }

    @Override
    public Employee update(Employee employee) {
        employee.setJob(organizationRestClient.findByJob(15L)); //rh job
        employee.setDepartment(organizationRestClient.findByDepartment(15L)); //Department RH
        return employeeRepository.save(employee);
    }

    @Override
    public void delete(Long id) {
       Employee employee = employeeRepository.findById(id).get();
       HumanResourceManager rh = humanResourceManagerRepository.findAll().stream().filter(rh1 -> rh1.getRegistrationNumber().equals(employee.getRegistrationNumber())).findAny().get();
       employeeRepository.delete(employee);
       humanResourceManagerRepository.delete(rh);
    }


    @Override
    public List<Employee>  findByDepartment(Long id) {
        List<Employee> humanResourceManagers = new ArrayList<>();
        employeeRepository.findAll()
                .forEach(employee -> {
                    for (HumanResourceManager rh:humanResourceManagerRepository.findAll()){
                        if(rh.getRegistrationNumber().equals(employee.getRegistrationNumber()))
                            if(employee.getDepartmentID().equals(id)){
                                employee.setJob(organizationRestClient.findByJob(employee.getJobID()));
                                employee.setDepartment(organizationRestClient.findByDepartment(id));
                                humanResourceManagers.add(employee);
                            }
                    }
                });
        return humanResourceManagers;
    }

    @Override
    public HumanResourceManager findRh(Long idRh) {
        return humanResourceManagerRepository.findById(idRh).orElse(null);
    }
}
