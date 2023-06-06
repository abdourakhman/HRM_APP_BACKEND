package ma.suptech.MSresource.API;

import ma.suptech.MSresource.enumerations.timeOffRequest.Type;
import ma.suptech.MSresource.models.TimeOffRequest;
import ma.suptech.MSresource.services.TimeOffRequestService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TimeOffRequestAPI {
    private final TimeOffRequestService timeOffRequestService;

    public TimeOffRequestAPI(TimeOffRequestService timeOffRequestService){
        this.timeOffRequestService = timeOffRequestService;
    }

    @GetMapping("/timeOffRequests")
    public List<TimeOffRequest> allTimeOffRequest(){
        return timeOffRequestService.list();
    }

    @GetMapping("/timeOffRequests/employee/{id}")
    public List<TimeOffRequest> TimeOffRequestByEmployee(@PathVariable Long id){
        return timeOffRequestService.listTimeOffRequestByEmployee(id);
    }

    @GetMapping("/timeOffRequests/type/{type}")
    public List<TimeOffRequest> TimeOffRequestByType(@PathVariable Type type){
        return timeOffRequestService.listTimeOffRequestByType(type);
    }


    @GetMapping("/timeOffRequests/{id}")
    public TimeOffRequest findTimeOffRequest(@PathVariable Long id){
        return timeOffRequestService.find(id);
    }

    @PostMapping("/timeOffRequest")
    public TimeOffRequest addTimeOffRequest(@RequestBody TimeOffRequest timeOffRequest){
        return timeOffRequestService.create(timeOffRequest);
    }

    @PutMapping("/timeOffRequest")
    public TimeOffRequest updateTimeOffRequest(@RequestBody TimeOffRequest timeOffRequest){
        return timeOffRequestService.update(timeOffRequest);
    }

    @DeleteMapping("/timeOffRequest/{id}")
    public void removeTimeOffRequest(@PathVariable Long id){
        timeOffRequestService.remove(id);
    }
}
