package ma.suptech.MSorganization.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.suptech.MSorganization.enumerations.Responsibility;

@Entity@Data
@NoArgsConstructor@AllArgsConstructor
public class Job {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String description;
    private String skills;
    private Responsibility levelOfResponsibility;

}


