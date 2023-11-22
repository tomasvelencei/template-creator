package com.solution.documentcreator.usecase.applicant.find.exception;

import java.io.Serial;

public class ApplicantNotFoundException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 8763193815681197422L;

    public ApplicantNotFoundException(String message) {
        super(message);
    }
}
