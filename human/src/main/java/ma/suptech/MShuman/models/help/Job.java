package ma.suptech.MShuman.models.help;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.suptech.MShuman.enumerations.Responsibility;

@Data@NoArgsConstructor@AllArgsConstructor
public class Job {
    private Long id;
    private String title;
    private String description;
    private String skills;
    private Responsibility levelOfResponsibility;
}
