package ma.suptech.MSresource.services;


import ma.suptech.MSresource.models.TimeSheet;

import java.util.List;

public interface TimeSheetService {
    TimeSheet create(TimeSheet timeSheet);
    TimeSheet update(TimeSheet timeSheet);
    TimeSheet find(Long id);
    List<TimeSheet>getAll();
    List<TimeSheet>getByEmployee(Long id);
}
