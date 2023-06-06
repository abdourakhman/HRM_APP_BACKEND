package ma.suptech.MSresource.API;


import ma.suptech.MSresource.models.TimeSheet;
import ma.suptech.MSresource.services.TimeSheetService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TimeSheetAPI {

    private final TimeSheetService timeSheetService;

    public TimeSheetAPI(TimeSheetService timeSheetService){
        this.timeSheetService =timeSheetService;
    }

    @PostMapping("/timesheet")
    public TimeSheet create(@RequestBody TimeSheet timeSheet){
        return timeSheetService.create(timeSheet);
    }

    @PutMapping("/timesheet")
    public TimeSheet update(@RequestBody TimeSheet timeSheet){
        return timeSheetService.update(timeSheet);
    }

    @GetMapping("/timesheets/{id}")
    public TimeSheet find(@PathVariable Long id){
        return timeSheetService.find(id);
    }

    @GetMapping("/timesheets")
    public List<TimeSheet> list(){
        return timeSheetService.getAll();
    }

    @GetMapping("/timesheets/employee/{id}")
    public List<TimeSheet> listTimeSheetEmployee(@PathVariable Long id){
        return timeSheetService.getByEmployee(id);
    }
}
