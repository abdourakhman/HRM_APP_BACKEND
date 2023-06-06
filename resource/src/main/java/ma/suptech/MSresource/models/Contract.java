package ma.suptech.MSresource.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.suptech.MSresource.enumerations.Contract.Status;
import ma.suptech.MSresource.enumerations.Contract.Type;
import ma.suptech.MSresource.models.helper.Employee;

import java.time.LocalDate;

@Entity @Data
@NoArgsConstructor @AllArgsConstructor
public class Contract {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id ;
    private LocalDate start, end;
    private Type type;
    private int remuneration;
    private Status status;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Long employeeID ;
    @Transient
    private Employee employee;
}
