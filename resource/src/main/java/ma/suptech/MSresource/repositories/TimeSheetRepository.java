package ma.suptech.MSresource.repositories;

import ma.suptech.MSresource.models.TimeSheet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TimeSheetRepository extends JpaRepository<TimeSheet,Long> {
}
