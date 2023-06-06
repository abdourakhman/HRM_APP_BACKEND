package ma.suptech.MSevaluation.models.helper;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class SpecificNote {
    private String criterion;
    private int note;
    private String comments;
}
