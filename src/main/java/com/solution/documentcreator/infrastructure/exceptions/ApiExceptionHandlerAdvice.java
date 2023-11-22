package com.solution.documentcreator.infrastructure.exceptions;

import com.solution.documentcreator.infrastructure.out.presenters.ViewCreator;
import com.solution.documentcreator.usecase.applicant.find.exception.ApplicantNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class ApiExceptionHandlerAdvice {

    private static final Logger LOGGER = LoggerFactory.getLogger(ApiExceptionHandlerAdvice.class);

    private static final String TEMPLATE_NAME = "api-error";
    private final ViewCreator errorViewCreator;

    @Autowired
    public ApiExceptionHandlerAdvice(ViewCreator errorViewCreator) {
        this.errorViewCreator = errorViewCreator;
    }

    @ExceptionHandler({ApplicantNotFoundException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ModelAndView handleApplicantNotFoundException(ApplicantNotFoundException exception) {
        LOGGER.error(exception.getMessage(), exception);
        return this.errorViewCreator.create(TEMPLATE_NAME, exception);
    }

    @ExceptionHandler({TemplateFileCreationException.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ModelAndView handleTemplateFileCreationException(TemplateFileCreationException exception) {
        LOGGER.error(exception.getMessage(), exception);
        return this.errorViewCreator.create(TEMPLATE_NAME, exception);
    }

}
