package ma.suptech.MSemployee_evaluation.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.suptech.MSemployee_evaluation.ennumerations.Gender;
import ma.suptech.MSemployee_evaluation.ennumerations.Profile;
import ma.suptech.MSemployee_evaluation.ennumerations.Status;


import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;


@Entity @Data
@NoArgsConstructor @AllArgsConstructor
public class Employee {
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
    private Profile profile;
    private Status status;
    private String photoUrl;
    private Long managerID;
    private Long jobID;
    private Long departmentID;
    @ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JoinTable(name = "employee_evaluations",
            joinColumns = @JoinColumn(name = "employee_id"),
            inverseJoinColumns = @JoinColumn(name = "evaluation_id")
    )
    private Set<Evaluation> evaluations = new HashSet<>();
    @Transient
    private Job job;
    @Transient
    private Department department;

}
