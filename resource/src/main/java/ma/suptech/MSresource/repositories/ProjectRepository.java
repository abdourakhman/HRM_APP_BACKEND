package ma.suptech.MSresource.repositories;

import ma.suptech.MSresource.models.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project,Long> {
}
