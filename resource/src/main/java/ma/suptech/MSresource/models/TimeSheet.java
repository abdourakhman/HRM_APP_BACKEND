package ma.suptech.MSresource.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.suptech.MSresource.enumerations.timesheet.Absence;
import ma.suptech.MSresource.models.helper.Employee;

import java.time.Duration;
import java.time.LocalDate;

@Entity @Data
@NoArgsConstructor
@AllArgsConstructor
public class TimeSheet {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private LocalDate createdAt;
    private Duration hoursWorked;
    private Absence absence;
    private String comment;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Long employeeID;
    @Transient
    private Employee employee;
}
