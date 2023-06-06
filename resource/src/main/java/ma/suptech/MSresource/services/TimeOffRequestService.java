package ma.suptech.MSresource.services;



import ma.suptech.MSresource.enumerations.timeOffRequest.Type;
import ma.suptech.MSresource.models.TimeOffRequest;

import java.util.List;

public interface TimeOffRequestService {
    TimeOffRequest create(TimeOffRequest timeOffRequest);
    TimeOffRequest update(TimeOffRequest timeOffRequest);
    List<TimeOffRequest>list();
    List<TimeOffRequest>listTimeOffRequestByEmployee(Long id);
    List<TimeOffRequest>listTimeOffRequestByType(Type type);
    TimeOffRequest find(Long id);
    void remove(Long id);

}
