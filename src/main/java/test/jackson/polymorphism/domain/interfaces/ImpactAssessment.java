package test.jackson.polymorphism.domain.interfaces;


import test.jackson.polymorphism.domain.enumeration.Impact;
import test.jackson.polymorphism.domain.enumeration.ImpactAssessmentType;

public interface ImpactAssessment {
    ImpactAssessmentType getType();

    void setType(ImpactAssessmentType type);

    Impact getImpact();

    void setImpact(Impact impact);
}
