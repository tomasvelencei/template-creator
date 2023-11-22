package com.solution.documentcreator.infrastructure.exceptions;

import java.io.Serial;

public class TemplateFileCreationException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = -3746237846137641823L;

    public TemplateFileCreationException(String message) {
        super(message);
    }
}
