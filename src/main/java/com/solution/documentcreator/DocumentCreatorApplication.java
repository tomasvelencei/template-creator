package com.solution.documentcreator;

import com.solution.documentcreator.infrastructure.configurations.TemplateFileConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties({TemplateFileConfiguration.class})
@ConfigurationPropertiesScan()
public class DocumentCreatorApplication {

    public static void main(String[] args) {
        SpringApplication.run(DocumentCreatorApplication.class, args);
    }

}
