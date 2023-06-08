package ma.suptech.MShuman.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity @Data
@NoArgsConstructor @AllArgsConstructor
public class HumanResourceManager {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String registrationNumber; //identify rh from employee table
}
