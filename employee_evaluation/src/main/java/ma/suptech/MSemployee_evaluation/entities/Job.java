package ma.suptech.MSemployee_evaluation.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.suptech.MSemployee_evaluation.ennumerations.Responsibility;

@Data@NoArgsConstructor@AllArgsConstructor
public class Job {
    private Long id;
    private String title;
    private String description;
    private String skills;
    private Responsibility levelOfResponsibility;
}
