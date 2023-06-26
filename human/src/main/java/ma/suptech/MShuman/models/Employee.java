package ma.suptech.MShuman.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.suptech.MShuman.enumerations.Gender;
import ma.suptech.MShuman.enumerations.Status;
import ma.suptech.MShuman.models.help.Department;
import ma.suptech.MShuman.models.help.Job;

import java.time.LocalDate;



@Entity @Data
@NoArgsConstructor @AllArgsConstructor
public class Employee {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
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
    @JsonProperty(access = JsonProperty.Access.READ_WRITE)
    @ManyToOne
    private Manager manager;
    private Long jobID;
    private Long departmentID;
    @Transient
    private Job job;
    @Transient
    private Department department;

}
