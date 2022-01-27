package test.jackson.polymorphism;

import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import test.jackson.polymorphism.domain.enumeration.Impact;
import test.jackson.polymorphism.domain.models.ElementModel;
import test.jackson.polymorphism.domain.models.QuantitativeImpactAssessmentModel;
import test.jackson.polymorphism.repository.ElementRepository;

import java.math.BigDecimal;
import java.util.UUID;

@SpringBootTest
@RequiredArgsConstructor
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class RepositoryTests {
    @Autowired
    private ElementRepository elementRepository;

    @Test
    @Order(1)
    public void testRepositorySaveElement(){
        ElementModel elementModel = ElementModel.builder()
                .id(UUID.randomUUID().toString())
                .name("Element Name")
                .description("Element Description")
                .impactAssessment(QuantitativeImpactAssessmentModel.builder()
                        .economicValue(BigDecimal.valueOf(99999999999.99))
                        .impact(Impact.HIGH)
                        .build())
                .build();

        this.elementRepository.save(elementModel);
    }
}
