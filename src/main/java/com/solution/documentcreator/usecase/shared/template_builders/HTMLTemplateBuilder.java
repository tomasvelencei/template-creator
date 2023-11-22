package com.solution.documentcreator.usecase.shared.template_builders;

import com.solution.documentcreator.usecase.shared.template_parts.ViewContent;
import com.solution.documentcreator.usecase.shared.template_parts.DocumentSection;

import java.util.Arrays;

public class HTMLTemplateBuilder implements TemplateBuilder {

    private final StringBuilder stringBuilder = new StringBuilder();


    public HTMLTemplateBuilder openWithAttribute(DocumentSection documentSection, String attributeName, String attributeValue) {
        this.stringBuilder.append(String.format(documentSection.getOpeningTag(), attributeName + "=\"" + attributeValue + "\""));
        return this;
    }

    @Override
    public HTMLTemplateBuilder open(DocumentSection... documentSection) {
        Arrays.stream(documentSection).forEach(section -> this.stringBuilder.append(section.getOpeningTag()));
        return this;
    }

    @Override
    public HTMLTemplateBuilder close(DocumentSection... documentSection) {
        Arrays.stream(documentSection).forEach(section -> this.stringBuilder.append(section.getClosingTag()));
        return this;
    }

    @Override
    public HTMLTemplateBuilder withContent(ViewContent... contents) {
        Arrays.stream(contents).forEach(content -> this.stringBuilder.append(content.getContent()));
        return this;
    }

    @Override
    public String build() {
        return this.stringBuilder.toString();
    }
}
