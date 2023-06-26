package ma.suptech.MShuman.services;

import ma.suptech.MShuman.client.OrganizationRestClient;
import ma.suptech.MShuman.enumerations.Gender;
import ma.suptech.MShuman.enumerations.Status;
import ma.suptech.MShuman.models.Employee;
import ma.suptech.MShuman.models.help.Department;
import ma.suptech.MShuman.models.help.Job;
import ma.suptech.MShuman.repositories.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;

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
    public Employee findEmployeeByRegistrationNumber(String registrationNumber) {
        for(Employee e : employeeRepository.findAll()){
            if(e.getRegistrationNumber().equals(registrationNumber)){
                e.setJob(organizationRestClient.findByJob(e.getJobID()));
                e.setDepartment(organizationRestClient.findByDepartment(e.getDepartmentID()));
                return e;
            }
        }
        return null;
    }

    @Override
    public Employee save(Employee employee) {
        employee.setRegistrationNumber(UUID.randomUUID().toString());
        employee.setHiringDate(LocalDate.now());
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

    @Override
    public Map<String,Integer> getNumberOfEmployeeByDepartment(){
        Map<String,Integer> numberEmployeeByDepartment = new HashMap<>();
        this.organizationRestClient.listDepartment()
                .forEach(department -> {
                    int numberEmployee = 0;
                    numberEmployeeByDepartment.put(department.getName(),numberEmployee);

                    for (Employee e : this.employeeRepository.findAll()){
                        if (e.getDepartmentID().equals(department.getId())){
                            numberEmployee++;
                            numberEmployeeByDepartment.replace(department.getName(),numberEmployee);
                        }
                    }
                });
        return numberEmployeeByDepartment;
    }

    @Override
    public Map<String,Integer> getNumberOfEmployeeByJob(){
        Map<String,Integer> numberEmployeeByJob = new HashMap<>();
        this.organizationRestClient.listJob()
                .forEach(job -> {
                    int numberEmployee = 0;
                    numberEmployeeByJob.put(job.getTitle(),numberEmployee);

                    for (Employee e : this.employeeRepository.findAll()){
                        if (e.getJobID().equals(job.getId())){
                            numberEmployee++;
                            numberEmployeeByJob.replace(job.getTitle(),numberEmployee);
                        }
                    }
                });
        return numberEmployeeByJob;
    }

    @Override
    public Map<String,Integer> getNumberOfEmployeeByGender(){
        Map<String,Integer> numberEmployeeByGender = new HashMap<>();
        int numberOfMan = 0 , numberOfWoman = 0;
        numberEmployeeByGender.put("Male",numberOfMan);
        numberEmployeeByGender.put("Female",numberOfWoman);
        for (Employee e : this.employeeRepository.findAll()){
            if (e.getGender().equals(Gender.MALE)){
                numberOfMan++;
                numberEmployeeByGender.replace("Male",numberOfMan);
            }
            else{
                numberOfWoman++;
                numberEmployeeByGender.replace("Female",numberOfWoman);
            }
        }
        return numberEmployeeByGender;
    }

    @Override
    public Long getTotalEmployee() {
        return employeeRepository.count();
    }

    @Override
    public int getNumberOfActiveWorker() {
        return employeeRepository.findAll().stream()
                .filter(employee -> employee.getStatus().equals(Status.ACTIVE)).toList().size();
    }

    @Override
    public int getAverageAge(){
        int sumAge = 0, numberOfeEmployee = 0;
        for (Employee e : this.employeeRepository.findAll()){
            sumAge+= LocalDate.now().getYear() - e.getBirthday().getYear();
            numberOfeEmployee++;
        }
        return sumAge/numberOfeEmployee;
    }
}
