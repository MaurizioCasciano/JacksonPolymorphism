package test.jackson.polymorphism.configuration;

import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@RequiredArgsConstructor
public class JacksonConfiguration {
    private final List<Module> customModules;

    @Bean
    public ObjectMapper objectMapper(){
        return this.configure(new ObjectMapper());
    }


    private  <T extends ObjectMapper> T configure(T mapper) {
        // pretty print
        mapper.enable(SerializationFeature.INDENT_OUTPUT);

        // register default modules
        mapper.findAndRegisterModules();
        // register custom modules
        mapper.registerModules(this.customModules);

        return mapper;
    }
}
