package test.jackson.polymorphism.domain.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import test.jackson.polymorphism.domain.enumeration.ImpactAssessmentType;
import test.jackson.polymorphism.domain.interfaces.QualitativeImpactAssessment;

@Data
@SuperBuilder
@NoArgsConstructor
public class QualitativeImpactAssessmentModel extends ImpactAssessmentModel implements QualitativeImpactAssessment {

    {
        super.type = ImpactAssessmentType.QUALITATIVE;
    }
}
