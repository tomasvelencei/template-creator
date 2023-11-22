package com.solution.documentcreator.usecase.applicant.create_template.formats;

import com.solution.documentcreator.usecase.shared.template_builders.TemplateBuilder;
import com.solution.documentcreator.usecase.shared.template_parts.HtmlTag;

import static com.solution.documentcreator.usecase.applicant.create_template.ApplicantTemplateContent.*;

public class ApplicantHTMLTemplateBuilder implements ApplicantTemplateBuilder {

    private final TemplateBuilder builder;

    public ApplicantHTMLTemplateBuilder(TemplateBuilder builder) {
        this.builder = builder;
    }

    public String createTemplate() {
        return this.builder
                .open(HtmlTag.DOCTYPE_DECLARATION)
                .open(HtmlTag.HTML)
                .open(HtmlTag.HEAD, HtmlTag.TITLE)
                .withContent(NAME_SPACEHOLDER, SEPARATOR, MAIN_TITLE)
                .close(HtmlTag.TITLE, HtmlTag.HEAD)
                .open(HtmlTag.BODY, HtmlTag.H1)
                .withContent(MAIN_TITLE)
                .close(HtmlTag.H1)
                .open(HtmlTag.PARAGRAPH)
                .openWithAttribute(HtmlTag.LINK,"href", REPOSITORY_URL_SPACEHOLDER.getContent())
                .withContent(SUBTITLE)
                .close(HtmlTag.LINK, HtmlTag.PARAGRAPH)
                .open(HtmlTag.PARAGRAPH)
                .withContent(DETAILS)
                .close(HtmlTag.PARAGRAPH)
                .openWithAttribute(HtmlTag.TABLE, "border", "1px solid black")
                .open(HtmlTag.TABLE_ROW, HtmlTag.TABLE_DATA)
                .withContent(NAME)
                .close(HtmlTag.TABLE_DATA)
                .open(HtmlTag.TABLE_DATA)
                .withContent(NAME_SPACEHOLDER)
                .close(HtmlTag.TABLE_DATA, HtmlTag.TABLE_ROW)
                .open(HtmlTag.TABLE_ROW, HtmlTag.TABLE_DATA)
                .withContent(CONTACT)
                .close(HtmlTag.TABLE_DATA)
                .open(HtmlTag.TABLE_DATA)
                .withContent(EMAIL_SPACEHOLDER)
                .close(HtmlTag.TABLE_DATA, HtmlTag.TABLE_ROW, HtmlTag.TABLE)
                .openWithAttribute(HtmlTag.LINK,"href", TARGET_URL.getContent())
                .withContent(TARGET)
                .close(HtmlTag.LINK, HtmlTag.BODY)
                .close(HtmlTag.HTML)
                .build();
    }
}
