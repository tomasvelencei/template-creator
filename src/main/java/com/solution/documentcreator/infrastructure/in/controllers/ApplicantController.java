package com.solution.documentcreator.infrastructure.in.controllers;

import com.solution.documentcreator.usecase.applicant.find.exception.ApplicantNotFoundException;
import org.springframework.web.servlet.ModelAndView;

public interface ApplicantController {

    ModelAndView getApplicantInfoById(long id) throws ApplicantNotFoundException;
}
