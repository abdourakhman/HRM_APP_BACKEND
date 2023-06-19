package ma.suptech.MSresource.services;

import ma.suptech.MSresource.client.HumanRestClient;
import ma.suptech.MSresource.models.Project;
import ma.suptech.MSresource.models.helper.Manager;
import ma.suptech.MSresource.repositories.ProjectRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProjectServiceImpl implements ProjectService {
    private final HumanRestClient humanRestClient;
    private final ProjectRepository projectRepository;

    public ProjectServiceImpl(HumanRestClient humanRestClient, ProjectRepository projectRepository) {
        this.humanRestClient = humanRestClient;
        this.projectRepository = projectRepository;
    }

    @Override
    public Project add(Project project) {
        project.setManager(humanRestClient.findManager(project.getManagerID()));
        return projectRepository.save(project);
    }

    @Override
    public Project update(Project project) {
        project.setManager(humanRestClient.findManager(project.getManagerID()));
        return projectRepository.save(project);
    }

    @Override
    public Project findOne(Long id) {
        Project project = projectRepository.findById(id).get();
        project.setManager(humanRestClient.findManager(project.getManagerID()));
        return project;
    }

    @Override
    public List<Project> findByManager(Long idManager) {
        Manager manager =humanRestClient.findManager(idManager);
        return projectRepository.findAll().stream()
                .filter(project -> project.getManagerID().equals(manager.getId()))
                .map(project -> {
                    project.setManager(manager);
                    return project;
                }).collect(Collectors.toList());
    }

    @Override
    public List<Project> findAll() {
        return projectRepository.findAll().stream()
                .map(project -> {
                    project.setManager(humanRestClient.findManager(project.getManagerID()));
                    return project;
                }).collect(Collectors.toList());
    }

    @Override
    public int getNumberOnGoingProject() {
        return projectRepository.findAll()
                .stream().filter(project -> project.getEnd().isAfter(LocalDate.now())).toList().size();
    }

    @Override
    public void delete(Long id) {
        projectRepository.deleteById(id);
    }
}
