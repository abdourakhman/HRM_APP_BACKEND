package ma.suptech.MShuman.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.suptech.MShuman.enumerations.Gender;
import ma.suptech.MShuman.enumerations.Status;
import ma.suptech.MShuman.models.help.Department;
import ma.suptech.MShuman.models.help.Job;

import java.time.LocalDate;
import java.util.Collection;
@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Manager {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
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
    @OneToMany(mappedBy = "manager")
    private Collection<Employee> employees;
    private Long jobID;
    private Long departmentID;
    @Transient
    private Job job;
    @Transient
    private Department department;
}
