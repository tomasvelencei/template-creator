package com.solution.documentcreator.infrastructure.out.presenters;

import com.solution.documentcreator.usecase.applicant.find.ports.ApplicantResponseModel;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;

@Service
@Qualifier("applicantViewCreator")
public class ApplicantViewCreator implements ViewCreator {

    @Override
    public <T> ModelAndView create(String filename, T content) {
        var model = (ApplicantResponseModel) content;
        var properties = new HashMap<String, String>();
        properties.put("name", model.name());
        properties.put("email", model.email());
        properties.put("repositoryUrl", model.repositoryUrl());
        return new ModelAndView(filename, properties);
    }
}
