package ma.suptech.MShuman.services;

import ma.suptech.MShuman.client.OrganizationRestClient;
import ma.suptech.MShuman.models.HumanResourceManager;
import ma.suptech.MShuman.models.help.Department;
import ma.suptech.MShuman.repositories.HumanResourceManagerRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HumanResourceManagerServiceImpl implements HumanResourceManagerService {
    private final HumanResourceManagerRepository humanResourceManagerRepository;
    private final OrganizationRestClient organizationRestClient;


    public HumanResourceManagerServiceImpl(HumanResourceManagerRepository humanResourceManagerRepository, OrganizationRestClient organizationRestClient){
        this.humanResourceManagerRepository = humanResourceManagerRepository;
        this.organizationRestClient = organizationRestClient;
    }

    @Override
    public List<HumanResourceManager> listRH() {
        List<HumanResourceManager> humanResourceManagers = new ArrayList<>();
        humanResourceManagerRepository.findAll().forEach(humanResourceManager -> {
            humanResourceManager.setJob(organizationRestClient.findByJob(humanResourceManager.getJobID()));
            humanResourceManager.setDepartment(organizationRestClient.findByDepartment(humanResourceManager.getDepartmentID()));
            humanResourceManagers.add(humanResourceManager);
        });
        return humanResourceManagers;
    }


    @Override
    public HumanResourceManager find(Long id) {
        HumanResourceManager humanResourceManager = humanResourceManagerRepository.findById(id).orElse(null);
        if(humanResourceManager != null){
            humanResourceManager.setJob(organizationRestClient.findByJob(humanResourceManager.getJobID()));
            humanResourceManager.setDepartment(organizationRestClient.findByDepartment(humanResourceManager.getDepartmentID()));
        }
        return humanResourceManager;
    }

    @Override
    public HumanResourceManager save(HumanResourceManager humanResourceManager) {
        HumanResourceManager rh = humanResourceManagerRepository.save(humanResourceManager);
        rh.setJob(organizationRestClient.findByJob(humanResourceManager.getJobID()));
        rh.setDepartment(organizationRestClient.findByDepartment(humanResourceManager.getDepartmentID()));
        return rh;
    }

    @Override
    public HumanResourceManager update(HumanResourceManager humanResourceManager) {
        HumanResourceManager rh = humanResourceManagerRepository.save(humanResourceManager);
        rh.setJob(organizationRestClient.findByJob(humanResourceManager.getJobID()));
        rh.setDepartment(organizationRestClient.findByDepartment(humanResourceManager.getDepartmentID()));
        return rh;
    }

    @Override
    public void delete(Long id) {
        humanResourceManagerRepository.deleteById(id);
    }


    @Override
    public List<HumanResourceManager>  findByDepartment(Long id) {
        Department department = organizationRestClient.findByDepartment(id);
        List<HumanResourceManager> humanResourceManagers;
        humanResourceManagers = humanResourceManagerRepository.findAll().stream().filter(humanResourceManager -> department.getId()==humanResourceManager.getDepartmentID()).toList();
        humanResourceManagers.forEach(humanResourceManager -> {humanResourceManager.setDepartment(department);
            humanResourceManager.setJob(organizationRestClient.findByJob(humanResourceManager.getJobID()));
        });
        return humanResourceManagers;
    }


}
