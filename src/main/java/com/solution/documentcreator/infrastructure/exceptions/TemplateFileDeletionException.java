package com.solution.documentcreator.infrastructure.exceptions;

import java.io.Serial;

public class TemplateFileDeletionException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 967237846137641823L;

    public TemplateFileDeletionException(String message) {
        super(message);
    }
}
