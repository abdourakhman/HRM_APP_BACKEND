package ma.suptech.MSresource.services;

import ma.suptech.MSresource.client.HumanRestClient;
import ma.suptech.MSresource.enumerations.timeOffRequest.Type;
import ma.suptech.MSresource.models.TimeOffRequest;
import ma.suptech.MSresource.models.helper.Employee;
import ma.suptech.MSresource.repositories.TimeOffRequestRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TimeOffRequestServiceImpl implements TimeOffRequestService {

    private final TimeOffRequestRepository timeOffRequestRepository;
    private final HumanRestClient humanRestClient;


    public TimeOffRequestServiceImpl(TimeOffRequestRepository timeOffRequestRepository, HumanRestClient humanRestClient){
        this.timeOffRequestRepository = timeOffRequestRepository;
        this.humanRestClient = humanRestClient;
    }

    @Override
    public TimeOffRequest create(TimeOffRequest timeOffRequest) {
        timeOffRequest.setEmployee(humanRestClient.findEmployee(timeOffRequest.getEmployeeID()));
        TimeOffRequest timeOffRequestSaved = timeOffRequestRepository.save(timeOffRequest);
        return timeOffRequestSaved;
    }

    @Override
    public TimeOffRequest update(TimeOffRequest timeOffRequest) {
        timeOffRequest.setEmployee(humanRestClient.findEmployee(timeOffRequest.getEmployeeID()));
        TimeOffRequest timeOffRequestSaved =  timeOffRequestRepository.save(timeOffRequest);
        return timeOffRequestSaved;
    }

    @Override
    public List<TimeOffRequest> list() {
        List<TimeOffRequest> allTimeOffRequest = new ArrayList<>();
        timeOffRequestRepository.findAll().forEach(timeOffRequest -> {
            timeOffRequest.setEmployee(humanRestClient.findEmployee(timeOffRequest.getEmployeeID()));
            allTimeOffRequest.add(timeOffRequest);
        });
        return allTimeOffRequest;
    }

    @Override
    public List<TimeOffRequest> listTimeOffRequestByEmployee(Long id) {
        Employee employee = humanRestClient.findEmployee(id);
        List<TimeOffRequest> timeOffRequests;
        timeOffRequests =timeOffRequestRepository.findAll()
                .stream().filter(timeOffRequest ->
                   timeOffRequest.getEmployeeID() == employee.getId()
                ).toList();
        timeOffRequests.forEach(timeOffRequest -> {timeOffRequest.setEmployee(employee);});
        return timeOffRequests;
    }


    @Override
    public List<TimeOffRequest> listTimeOffRequestByType(Type type) {

        return timeOffRequestRepository.findAll()
                .stream().filter(timeOffRequest ->
                        timeOffRequest.getType().equals(type)
                ).map(timeOffRequest -> {
                    timeOffRequest.setEmployee(humanRestClient.findEmployee(timeOffRequest.getEmployeeID()));
                    return timeOffRequest;
                }).collect(Collectors.toList());
    }

    @Override
    public TimeOffRequest find(Long id) {
        TimeOffRequest timeOffRequest = timeOffRequestRepository.findById(id).orElse(null);
        if(timeOffRequest != null){
            timeOffRequest.setEmployee(humanRestClient.findEmployee(timeOffRequest.getEmployeeID()));
        }
        return timeOffRequest;
    }

    @Override
    public void remove(Long id) {
        timeOffRequestRepository.deleteById(id);
    }
}
