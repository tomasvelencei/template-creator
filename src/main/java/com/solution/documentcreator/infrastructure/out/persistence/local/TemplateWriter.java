package com.solution.documentcreator.infrastructure.out.persistence.local;

public interface TemplateWriter {

    void writeToTemplateFile(String template, String filename);
}
