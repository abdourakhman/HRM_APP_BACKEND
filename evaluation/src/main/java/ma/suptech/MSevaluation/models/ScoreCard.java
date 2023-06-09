package ma.suptech.MSevaluation.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.suptech.MSevaluation.models.helper.Employee;
import ma.suptech.MSevaluation.models.helper.SpecificNote;

import java.time.LocalDate;
import java.util.Collection;

@Entity @Data
@NoArgsConstructor @AllArgsConstructor
public class ScoreCard {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(columnDefinition = "JSON")
    private String specificNotes;//sous forme d'une liste d'objet / A deserialiser
    private String recommendations;
    private Long employeeID;
    @JsonManagedReference
    @ManyToOne
    private Evaluation evaluation;
    @Transient
    private Employee employee;

    public static String SpecificNote(Collection<SpecificNote> specificNotes) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(specificNotes);
    }
}
