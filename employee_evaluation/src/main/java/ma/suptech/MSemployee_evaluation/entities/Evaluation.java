package ma.suptech.MSemployee_evaluation.entities;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Entity @Data
@NoArgsConstructor @AllArgsConstructor
public class Evaluation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private LocalDate evaluationDate;
    private String goalsSet; //objective
    @Column(columnDefinition = "JSON")
    private String specificNotes;//sous forme d'une liste d'objet / A deserialiser
    private String recommendations;
    @ManyToMany(mappedBy = "evaluations")
    private Set<Employee> employees = new HashSet<>();

    public static String SpecificNote(Collection<SpecificNote> specificNotes) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(specificNotes);
    }
}

