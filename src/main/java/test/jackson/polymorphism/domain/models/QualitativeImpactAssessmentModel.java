package test.jackson.polymorphism.domain.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import test.jackson.polymorphism.domain.enumeration.ImpactAssessmentType;
import test.jackson.polymorphism.domain.interfaces.QualitativeImpactAssessment;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class QualitativeImpactAssessmentModel extends ImpactAssessmentModel implements QualitativeImpactAssessment {
    @Builder.Default
    private ImpactAssessmentType type = ImpactAssessmentType.QUALITATIVE;
}
