package test.jackson.polymorphism.configuration;

import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.databind.module.SimpleModule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import test.jackson.polymorphism.domain.interfaces.Element;
import test.jackson.polymorphism.domain.interfaces.ImpactAssessment;
import test.jackson.polymorphism.domain.models.ElementModel;
import test.jackson.polymorphism.domain.models.QualitativeImpactAssessmentModel;
import test.jackson.polymorphism.domain.models.QuantitativeImpactAssessmentModel;

@Configuration
public class JacksonModuleConfiguration {

    @Bean
    public Module abstractsMappingModule() {
        SimpleModule module = new SimpleModule();

        module.addAbstractTypeMapping(Element.class, ElementModel.class);
        module.addAbstractTypeMapping(ImpactAssessment.class, QualitativeImpactAssessmentModel.class);
        module.addAbstractTypeMapping(ImpactAssessment.class, QuantitativeImpactAssessmentModel.class);

        return module;
    }
}
