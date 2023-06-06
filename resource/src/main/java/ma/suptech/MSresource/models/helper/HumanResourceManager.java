package ma.suptech.MSresource.models.helper;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.suptech.MSresource.enumerations.helper.Gender;
import ma.suptech.MSresource.enumerations.helper.Status;

import java.time.LocalDate;

@NoArgsConstructor@AllArgsConstructor
@Data
public class HumanResourceManager {
    private Long id;
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
    private Long departmentID;
    private Long JobID;
}
