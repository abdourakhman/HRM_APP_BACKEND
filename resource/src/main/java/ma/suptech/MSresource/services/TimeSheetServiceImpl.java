package ma.suptech.MSresource.services;


import ma.suptech.MSresource.client.HumanRestClient;
import ma.suptech.MSresource.models.TimeSheet;
import ma.suptech.MSresource.models.helper.Employee;
import ma.suptech.MSresource.repositories.TimeSheetRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class TimeSheetServiceImpl implements TimeSheetService {

    private final TimeSheetRepository timeSheetRepository;
    private final HumanRestClient humanRestClient;

    public TimeSheetServiceImpl(TimeSheetRepository timeSheetRepository, HumanRestClient humanRestClient){
        this.timeSheetRepository = timeSheetRepository;
        this.humanRestClient = humanRestClient;
    }
    @Override
    public TimeSheet create(TimeSheet timeSheet) {
        timeSheet.setEmployee(humanRestClient.findEmployee(timeSheet.getEmployeeID()));
        return timeSheetRepository.save(timeSheet);
    }

    @Override
    public TimeSheet update(TimeSheet timeSheet) {
        timeSheet.setEmployee(humanRestClient.findEmployee(timeSheet.getEmployeeID()));
        return timeSheetRepository.save(timeSheet);
    }

    @Override
    public TimeSheet find(Long id) {
        TimeSheet timeSheet = timeSheetRepository.findById(id).orElse(null);
        if(timeSheet != null)
            timeSheet.setEmployee(humanRestClient.findEmployee(timeSheet.getEmployeeID()));
        return timeSheet;

    }

    @Override
    public List<TimeSheet> getAll() {

        List<TimeSheet> timeSheets = new ArrayList<>();
        timeSheetRepository.findAll().forEach(timeSheet -> {
            timeSheet.setEmployee(humanRestClient.findEmployee(timeSheet.getEmployeeID()));
            timeSheets.add(timeSheet);
        });
        return timeSheets;
    }

    @Override
    public List<TimeSheet> getByEmployee(Long id) {
        Employee employee = humanRestClient.findEmployee(id);
        List<TimeSheet> timeSheets ;
        timeSheets = timeSheetRepository.findAll().stream().filter(timeSheet -> timeSheet.getEmployeeID().equals(employee.getId())).toList();
        timeSheets.forEach(timeSheet -> timeSheet.setEmployee(employee));
        return timeSheets;
    }
}
