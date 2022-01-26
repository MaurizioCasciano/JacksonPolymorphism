package test.jackson.polymorphism;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import test.jackson.polymorphism.domain.enumeration.Impact;
import test.jackson.polymorphism.domain.interfaces.Element;
import test.jackson.polymorphism.domain.models.ElementModel;
import test.jackson.polymorphism.domain.models.QuantitativeImpactAssessmentModel;

import java.math.BigDecimal;
import java.util.UUID;

@SpringBootTest
@RequiredArgsConstructor
class PolymorphismApplicationTests {

	@Autowired
	private ObjectMapper objectMapper;

	@Test
	void contextLoads() {
	}

	@Test
	void testJacksonPolymorphism(){
		Element<String> element = ElementModel.builder()
				.id(UUID.randomUUID().toString())
				.name("Element Name")
				.description("Element Description")
				.impactAssessment(QuantitativeImpactAssessmentModel.builder()
						.economicValue(BigDecimal.valueOf(99999999999.99))
						.impact(Impact.HIGH)
						.build())
				.build();

		try {
			String JSON = this.objectMapper.writeValueAsString(element);
			System.out.println(JSON);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
	}
}
