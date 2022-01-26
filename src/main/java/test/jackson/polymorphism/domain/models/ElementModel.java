package test.jackson.polymorphism.domain.models;

import lombok.*;
import test.jackson.polymorphism.domain.interfaces.Element;
import test.jackson.polymorphism.domain.interfaces.ImpactAssessment;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ElementModel implements Element {
    private String id;
    private String name;
    private String description;

    private ImpactAssessment impactAssessment;
}
