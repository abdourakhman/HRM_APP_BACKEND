package ma.suptech.MShuman.services;

import ma.suptech.MShuman.client.OrganizationRestClient;
import ma.suptech.MShuman.models.Manager;
import ma.suptech.MShuman.models.help.Department;
import ma.suptech.MShuman.models.help.Job;
import ma.suptech.MShuman.repositories.ManagerRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ManagerServiceImpl implements ManagerService {
    private final ManagerRepository managerRepository;
    private final OrganizationRestClient organizationRestClient;


    public ManagerServiceImpl(ManagerRepository managerRepository, OrganizationRestClient organizationRestClient){
        this.managerRepository = managerRepository;
        this.organizationRestClient = organizationRestClient;
    }

    @Override
    public List<Manager> listManager() {
        List<Manager> managers = new ArrayList<>();
        managerRepository.findAll().forEach(manager -> {
            manager.setJob(organizationRestClient.findByJob(manager.getJobID()));
            manager.setDepartment(organizationRestClient.findByDepartment(manager.getDepartmentID()));
            managers.add(manager);
        });
        return managers;
    }


    @Override
    public Manager find(Long id) {
        Manager manager = managerRepository.findById(id).orElse(null);
        if(manager != null){
            manager.setJob(organizationRestClient.findByJob(manager.getJobID()));
            manager.setDepartment(organizationRestClient.findByDepartment(manager.getDepartmentID()));
        }
        return manager;
    }

    @Override
    public Manager save(Manager manager) {
        Manager managerSaved = managerRepository.save(manager);
        managerSaved.setJob(organizationRestClient.findByJob(manager.getJobID()));
        managerSaved.setDepartment(organizationRestClient.findByDepartment(manager.getDepartmentID()));
        return managerSaved;
    }

    @Override
    public Manager update(Manager manager) {
        Manager managerUpdated = managerRepository.save(manager);
        managerUpdated.setJob(organizationRestClient.findByJob(manager.getJobID()));
        managerUpdated.setDepartment(organizationRestClient.findByDepartment(manager.getDepartmentID()));
        return managerUpdated;
    }

    @Override
    public void delete(Long id) {
        managerRepository.deleteById(id);
    }

    @Override
    public List<Manager> findByJob(Long id) {
        Job job = organizationRestClient.findByJob(id);
        List<Manager> managers ;
        managers = managerRepository.findAll().stream().filter(manager -> job.getId()==manager.getJobID()).toList();
        managers.forEach(manager -> {manager.setJob(job);
            manager.setDepartment(organizationRestClient.findByDepartment(manager.getDepartmentID()));});
        return managers;
    }

    @Override
    public List<Manager>  findByDepartment(Long id) {
        Department department = organizationRestClient.findByDepartment(id);
        List<Manager> managers;
        managers = managerRepository.findAll().stream().filter(manager -> department.getId()==manager.getDepartmentID()).toList();
        managers.forEach(manager -> {manager.setDepartment(department);
            manager.setJob(organizationRestClient.findByJob(manager.getJobID()));
        });
        return managers;
    }


}
