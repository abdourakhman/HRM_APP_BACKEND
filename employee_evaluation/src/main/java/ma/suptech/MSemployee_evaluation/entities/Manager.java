package ma.suptech.MSemployee_evaluation.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.suptech.MSemployee_evaluation.ennumerations.Gender;
import ma.suptech.MSemployee_evaluation.ennumerations.Status;

import java.time.LocalDate;
@Data @NoArgsConstructor @AllArgsConstructor
public class Manager {
    private Long id;
    private String name;
    private String firstName;
    private Gender gender;
    private LocalDate birthday;
    private String address;
    private int telephone;
    private String email;
    private LocalDate hiringDate;
    private Status status ;
    private String photoUrl;
    private Long jobID;
    private Long departmentID;
}
