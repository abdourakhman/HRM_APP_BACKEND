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
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Long employeeID;
    @Transient
    private Employee employee;
}
