package ma.suptech.MSresource.services;

import ma.suptech.MSresource.models.Project;

import java.util.List;

public interface ProjectService {
    Project add (Project project);
    Project update (Project project);
    Project findOne (Long id);
    List<Project> findByManager (Long  idManager);
    List<Project> findAll ();

    void delete(Long id );
}
