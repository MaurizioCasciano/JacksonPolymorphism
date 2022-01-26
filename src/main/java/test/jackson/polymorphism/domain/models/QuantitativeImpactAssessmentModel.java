package test.jackson.polymorphism.domain.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import test.jackson.polymorphism.domain.enumeration.ImpactAssessmentType;
import test.jackson.polymorphism.domain.interfaces.QuantitativeImpactAssessment;

import java.math.BigDecimal;
import java.util.Currency;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class QuantitativeImpactAssessmentModel extends ImpactAssessmentModel implements QuantitativeImpactAssessment {

    @Builder.Default
    private ImpactAssessmentType type = ImpactAssessmentType.QUANTITATIVE;

    /**
     * ISO 4217 currency code for this currency.
     */
    @Builder.Default
    private String currencyCode = Currency.getInstance("EUR").getCurrencyCode();

    private BigDecimal economicValue;
}
