package com.solution.documentcreator.usecase.applicant.create_template;

import com.solution.documentcreator.usecase.applicant.create_template.formats.ApplicantTemplateBuilder;
import com.solution.documentcreator.usecase.applicant.create_template.ports.TemplateHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CreateApplicantTemplateUseCaseImpl implements CreateApplicantTemplateUseCase {

    private static final Logger LOGGER = LoggerFactory.getLogger(CreateApplicantTemplateUseCaseImpl.class);
    private final ApplicantTemplateBuilder templateBuilder;
    private final TemplateHandler handler;

    public CreateApplicantTemplateUseCaseImpl(ApplicantTemplateBuilder templateBuilder, TemplateHandler handler) {
        this.templateBuilder = templateBuilder;
        this.handler = handler;
    }

    @Override
    public String createTemplate(String templateName) {
        String template = this.templateBuilder.createTemplate();
        LOGGER.debug("Template created: {}", template);
        return this.handler.handle(template, templateName);
    }
}
