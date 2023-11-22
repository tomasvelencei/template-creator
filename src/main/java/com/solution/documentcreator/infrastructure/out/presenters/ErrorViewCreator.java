package com.solution.documentcreator.infrastructure.out.presenters;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;

@Service
@Qualifier("errorViewCreator")
public class ErrorViewCreator implements ViewCreator {

    @Override
    public <T> ModelAndView create(String filename, T content) {
        var exception = (Exception) content;
        var properties = new HashMap<String, Object>();
        properties.put("error_msg", exception.getMessage());
        return new ModelAndView(filename, properties);
    }
}
