package com.solution.documentcreator.infrastructure.out.persistence.local;

import com.solution.documentcreator.usecase.applicant.create_template.ports.TemplateHandler;
import org.springframework.stereotype.Service;

@Service
public class TemplateCreator implements TemplateHandler {

   private final TemplateWriter writer;

    public TemplateCreator(TemplateWriter writer) {
        this.writer = writer;
    }

    @Override
    public String handle(String template, String templateName) {
        this.writer.writeToTemplateFile(template, templateName);
        return template;
    }
}
