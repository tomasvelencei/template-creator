package com.solution.documentcreator.infrastructure.out.persistence.local;

import com.solution.documentcreator.infrastructure.configurations.TemplateFileConfiguration;
import com.solution.documentcreator.infrastructure.exceptions.TemplateFileCreationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

@Service
public class TemplateWriterImpl implements TemplateWriter {

    private static final Logger LOGGER = LoggerFactory.getLogger(TemplateWriterImpl.class);

    private final TemplateFileConfiguration configuration;

    @Autowired
    public TemplateWriterImpl(TemplateFileConfiguration configuration) {
        this.configuration = configuration;
    }

    @Override
    public void writeToTemplateFile(@NonNull String template, @NonNull String filename) {
        try {
            Files.write(
                    createTemplateFile(filename),
                    template.getBytes(),
                    StandardOpenOption.CREATE);
            LOGGER.info("Template file created: {}", filename);
        } catch (IOException | InvalidPathException ex) {
            LOGGER.error(ex.getMessage(), ex);
            throw new TemplateFileCreationException("Template file creation failed");
        }
    }

    private Path createTemplateFile(String filename) throws IOException {
        var dir = Path.of(configuration.getGeneratedTemplateDirPath());
        var file = dir.resolve(filename + configuration.getExtension());
        if (!Files.exists(dir)) {
            Files.createDirectories(dir);
        }
        return Files.createFile(file);
    }
}
