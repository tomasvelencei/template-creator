package com.solution.documentcreator.infrastructure.in.controllers;

import com.solution.documentcreator.infrastructure.out.presenters.ViewCreator;
import com.solution.documentcreator.usecase.applicant.create_template.CreateApplicantTemplateUseCase;
import com.solution.documentcreator.usecase.applicant.find.GetApplicantUseCase;
import com.solution.documentcreator.infrastructure.in.controllers.constants.RestConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(RestConstants.API_VERSION_V1 + RestConstants.APPLICANT_API)
public class ApplicantControllerImpl implements ApplicantController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ApplicantControllerImpl.class);
    private static final String TEMPLATE_FILENAME = "applicant-template-v1";
    private final GetApplicantUseCase getApplicantUseCase;
    private final CreateApplicantTemplateUseCase createApplicantTemplateUseCase;
    private final ViewCreator viewCreator;


    public ApplicantControllerImpl(GetApplicantUseCase getApplicantUseCase,
                                   CreateApplicantTemplateUseCase createApplicantTemplateUseCase,
                                   ViewCreator applicantViewCreator) {
        this.createApplicantTemplateUseCase = createApplicantTemplateUseCase;
        this.getApplicantUseCase = getApplicantUseCase;
        this.viewCreator = applicantViewCreator;
    }

    @GetMapping(value = "/{id}", produces = MediaType.TEXT_HTML_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ModelAndView getApplicantInfoById(@PathVariable("id") long id) {
        LOGGER.info("Template requested with applicant id: {}", id);
        var applicant = this.getApplicantUseCase.findById(id);
        var uniqueFileName = TEMPLATE_FILENAME + "-" + System.currentTimeMillis();
        this.createApplicantTemplateUseCase.createTemplate(uniqueFileName);
        return this.viewCreator.create(uniqueFileName, applicant);
    }
}