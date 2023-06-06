package ma.suptech.MSresource.repositories;

import ma.suptech.MSresource.models.TimeOffRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TimeOffRequestRepository extends JpaRepository<TimeOffRequest,Long> {
}
