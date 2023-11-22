package com.solution.documentcreator.infrastructure.out.presenters;

import org.springframework.web.servlet.ModelAndView;

public interface ViewCreator {

   <T> ModelAndView create(String filename, T content);
}
