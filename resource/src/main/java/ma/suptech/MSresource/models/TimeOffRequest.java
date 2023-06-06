package ma.suptech.MSresource.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.suptech.MSresource.enumerations.timeOffRequest.Status;
import ma.suptech.MSresource.enumerations.timeOffRequest.Type;
import ma.suptech.MSresource.models.helper.Employee;
import ma.suptech.MSresource.models.helper.HumanResourceManager;

import java.time.LocalDate;

@Entity @Data
@NoArgsConstructor @AllArgsConstructor
public class TimeOffRequest {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Type type;
    private String reason;
    private LocalDate requestDate;
    private Status requestStatus;
    private LocalDate desiredStartDate;
    private LocalDate desiredEndDate;
    private Long employeeID;
    private Long humanResourceManagerID;
    @Transient
    private Employee employee;
    @Transient
    private HumanResourceManager humanResourceManager;
}
