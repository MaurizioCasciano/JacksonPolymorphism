package test.jackson.polymorphism.domain.interfaces;

public interface Element {
    String getId();
    void setId(String id);

    String getName();
    void setName(String name);

    String getDescription();
    void setDescription(String description);

    ImpactAssessment getImpactAssessment();
    void setImpactAssessment(ImpactAssessment impactAssessment);
}
