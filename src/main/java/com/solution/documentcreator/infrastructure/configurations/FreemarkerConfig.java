package com.solution.documentcreator.infrastructure.configurations;

import freemarker.cache.FileTemplateLoader;
import freemarker.cache.MultiTemplateLoader;
import freemarker.cache.TemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.TemplateExceptionHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import java.io.File;
import java.io.IOException;
import java.util.TimeZone;

@org.springframework.context.annotation.Configuration
public class FreemarkerConfig {

    private final TemplateFileConfiguration configuration;

    @Autowired
    public FreemarkerConfig(TemplateFileConfiguration configuration) {
        this.configuration = configuration;
    }

    @Bean
    public Configuration init(Configuration cfg) throws IOException {
        FileTemplateLoader ftl1 = new FileTemplateLoader(new File(configuration.getGeneratedTemplateDirPath()));
        FileTemplateLoader ftl2 = new FileTemplateLoader(new File(configuration.getGeneratedTemplateDirPath()));
        MultiTemplateLoader mtl = new MultiTemplateLoader(new TemplateLoader[] {ftl1, ftl2});
        cfg.setDefaultEncoding("UTF-8");
        cfg.setTemplateLoader(mtl);
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        cfg.setLogTemplateExceptions(false);
        cfg.setWrapUncheckedExceptions(true);
        cfg.setFallbackOnNullLoopVariable(false);
        cfg.setSQLDateAndTimeTimeZone(TimeZone.getDefault());
        cfg.unsetCacheStorage();
        return cfg;
    }
}
