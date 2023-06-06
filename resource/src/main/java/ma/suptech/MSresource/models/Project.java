package ma.suptech.MSresource.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.suptech.MSresource.models.helper.Manager;

import java.time.LocalDate;
import java.util.Collection;

@Entity @AllArgsConstructor
@Data @NoArgsConstructor
public class Project {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String description;
    private LocalDate start;
    private LocalDate end;
    @OneToMany(mappedBy = "project")
    private Collection<GoalSet> goalSets;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Long ManagerID;
    @Transient
    private Manager manager;
}
