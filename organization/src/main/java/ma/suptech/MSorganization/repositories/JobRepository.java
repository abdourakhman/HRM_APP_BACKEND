package ma.suptech.MSorganization.repositories;

import ma.suptech.MSorganization.entities.Job;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<Job,Long> {
}
