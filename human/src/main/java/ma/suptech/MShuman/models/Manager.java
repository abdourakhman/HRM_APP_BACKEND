package ma.suptech.MShuman.models;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;
@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Manager {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String registrationNumber;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(mappedBy = "manager")
    private Collection<Employee> employees;
}
