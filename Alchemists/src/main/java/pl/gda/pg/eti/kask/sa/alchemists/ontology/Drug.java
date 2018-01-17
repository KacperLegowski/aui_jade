package pl.gda.pg.eti.kask.sa.alchemists.ontology;

import jade.content.Concept;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Drug implements Concept {
    private String name;
}
