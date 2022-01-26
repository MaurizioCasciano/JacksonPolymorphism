package test.jackson.polymorphism;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.*;
import org.junit.platform.commons.util.StringUtils;
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
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class PolymorphismApplicationTests {

	@Autowired
	private ObjectMapper objectMapper;
	private static Element ELEMENT;
	private static String SERIALIZED_JSON;
	private static Element DESERIALIZED_ELEMENT;
	private static String DESERIALIZED_JSON;

	@BeforeAll
	public static void init(){
		ELEMENT = ElementModel.builder()
				.id(UUID.randomUUID().toString())
				.name("Element Name")
				.description("Element Description")
				.impactAssessment(QuantitativeImpactAssessmentModel.builder()
						.economicValue(BigDecimal.valueOf(99999999999.99))
						.impact(Impact.HIGH)
						.build())
				.build();
	}

	@Test
	@Order(1)
	public void testJacksonPolymorphismSerialization(){
		try {
			SERIALIZED_JSON = this.objectMapper.writeValueAsString(ELEMENT);
			Assertions.assertNotNull(SERIALIZED_JSON);
			Assertions.assertTrue(StringUtils.isNotBlank(SERIALIZED_JSON));

			System.out.println("Serialized JSON");
			System.out.println(SERIALIZED_JSON);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
	}

	@Test
	@Order(2)
	public void testJacksonPolymorphismDeserialization(){
		try {
			DESERIALIZED_ELEMENT = this.objectMapper.readValue(SERIALIZED_JSON, Element.class);
			Assertions.assertNotNull(DESERIALIZED_ELEMENT);

			Assertions.assertEquals(ELEMENT, DESERIALIZED_ELEMENT);

			DESERIALIZED_JSON = this.objectMapper.writeValueAsString(DESERIALIZED_ELEMENT);
			Assertions.assertNotNull(DESERIALIZED_JSON);
			Assertions.assertTrue(StringUtils.isNotBlank(DESERIALIZED_JSON));

			Assertions.assertEquals(SERIALIZED_JSON, DESERIALIZED_JSON);

			System.out.println("Deserialized JSON");
			System.out.println(DESERIALIZED_JSON);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
	}
}
