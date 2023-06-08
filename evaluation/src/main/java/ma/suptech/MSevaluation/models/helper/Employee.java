package ma.suptech.MSevaluation.models.helper;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.suptech.MSevaluation.enumerations.Gender;
import ma.suptech.MSevaluation.enumerations.Status;

import java.time.LocalDate;

@Data @NoArgsConstructor @AllArgsConstructor
public class Employee {
    private Long id;
    private String registrationNumber;
    private String name;
    private String firstName;
    private Gender gender;
    private LocalDate birthday;
    private String address;
    private int telephone;
    private String email;
    private LocalDate hiringDate;
    private Status status;
    private String photoUrl;
    private Manager manager;
    private Long jobID;
    private Long departmentID;
}
