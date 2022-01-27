package test.jackson.polymorphism.domain.models;

import lombok.*;
import lombok.experimental.SuperBuilder;
import test.jackson.polymorphism.domain.enumeration.Impact;
import test.jackson.polymorphism.domain.enumeration.ImpactAssessmentType;
import test.jackson.polymorphism.domain.interfaces.ImpactAssessment;

@Data
@SuperBuilder
@NoArgsConstructor
public abstract class ImpactAssessmentModel implements ImpactAssessment {
    @Setter(AccessLevel.NONE)
    protected ImpactAssessmentType type;
    protected Impact impact;
}
