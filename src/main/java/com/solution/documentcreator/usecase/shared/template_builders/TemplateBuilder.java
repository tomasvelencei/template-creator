package com.solution.documentcreator.usecase.shared.template_builders;

import com.solution.documentcreator.usecase.shared.template_parts.DocumentSection;
import com.solution.documentcreator.usecase.shared.template_parts.ViewContent;

public interface TemplateBuilder {

    TemplateBuilder open(DocumentSection... documentSections);
    TemplateBuilder openWithAttribute(DocumentSection documentSection, String attributeName, String attributeValue);
    TemplateBuilder close(DocumentSection... documentSections);
    TemplateBuilder withContent(ViewContent... contents);
    String build();
}
