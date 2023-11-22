package com.solution.documentcreator.infrastructure.configurations;

import jakarta.validation.constraints.NotEmpty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

@ConfigurationProperties(prefix="templates")
@Validated
public class TemplateFileConfiguration {

    @NotEmpty
    private String generatedTemplateDirPath;
    @NotEmpty
    private String staticTemplateDirPath;
    @NotEmpty
    private String extension;
    private boolean keepTemplates;


    public String getGeneratedTemplateDirPath() {
        return generatedTemplateDirPath;
    }

    public void setGeneratedTemplateDirPath(String generatedTemplateDirPath) {
        this.generatedTemplateDirPath = generatedTemplateDirPath;
    }

    public String getStaticTemplateDirPath() {
        return staticTemplateDirPath;
    }

    public void setStaticTemplateDirPath(String staticTemplateDirPath) {
        this.staticTemplateDirPath = staticTemplateDirPath;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public boolean isKeepTemplates() {
        return keepTemplates;
    }

    public void setKeepTemplates(boolean keepTemplates) {
        this.keepTemplates = keepTemplates;
    }
}
