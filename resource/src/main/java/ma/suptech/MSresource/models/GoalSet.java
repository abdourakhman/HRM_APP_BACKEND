package ma.suptech.MSresource.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.suptech.MSresource.models.helper.Employee;

import java.time.LocalDate;

@Entity@Data
@AllArgsConstructor @NoArgsConstructor
public class GoalSet {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String description;
    private LocalDate targetDate;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Long employeeID;
    @JsonManagedReference
    @ManyToOne
    private Project project;
    @Transient
    private Employee employee;
}
