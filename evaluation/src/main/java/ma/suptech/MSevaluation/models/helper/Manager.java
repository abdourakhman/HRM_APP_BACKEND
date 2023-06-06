package ma.suptech.MSresource.models.helper;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.suptech.MSresource.enumerations.helper.Gender;
import ma.suptech.MSresource.enumerations.helper.Status;

import java.time.LocalDate;
import java.util.Collection;

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
    private Collection<Employee> employees;
    private Long jobID;
    private Long departmentID;
}
