package test.jackson.polymorphism.domain.models;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import test.jackson.polymorphism.domain.enumeration.Impact;
import test.jackson.polymorphism.domain.enumeration.ImpactAssessmentType;
import test.jackson.polymorphism.domain.interfaces.ImpactAssessment;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public abstract class ImpactAssessmentModel implements ImpactAssessment {
    private ImpactAssessmentType type;
    private Impact impact;
}
