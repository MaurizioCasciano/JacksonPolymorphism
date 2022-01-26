package test.jackson.polymorphism.domain.interfaces;

import java.math.BigDecimal;

public interface QuantitativeImpactAssessment extends ImpactAssessment {
    String getCurrencyCode();

    void setCurrencyCode(String currencyCode);

    BigDecimal getEconomicValue();

    void setEconomicValue(BigDecimal economicValue);
}
