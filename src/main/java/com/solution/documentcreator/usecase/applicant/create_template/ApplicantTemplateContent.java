package com.solution.documentcreator.usecase.applicant.create_template;

import com.solution.documentcreator.usecase.shared.template_parts.ViewContent;

public enum ApplicantTemplateContent implements ViewContent {

    NAME("Név"),
    NAME_SPACEHOLDER("${name}"),
    CONTACT("Elérhetőség"),
    EMAIL_SPACEHOLDER("${email}"),
    REPOSITORY_URL_SPACEHOLDER("${repositoryUrl}"),
    MAIN_TITLE("Teszt Feladat"),
    SUBTITLE("Megoldás"),
    SEPARATOR(" - "),
    DETAILS("A feladat elkészítőjének adatai"),
    TARGET("L&P Solutions"),
    TARGET_URL("http://lpsolutions.hu");

    private final String content;

    ApplicantTemplateContent(String content) {
        this.content = content;
    }

    @Override
    public String getContent() {
        return content;
    }
}
