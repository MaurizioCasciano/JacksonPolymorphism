package test.jackson.polymorphism.domain.models;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import test.jackson.polymorphism.domain.interfaces.Element;
import test.jackson.polymorphism.domain.interfaces.ImpactAssessment;

@Data
@Builder
@Document
@NoArgsConstructor
@AllArgsConstructor
public class ElementModel implements Element {
    @Id
    private String id;
    private String name;
    private String description;

    private ImpactAssessment impactAssessment;
}
