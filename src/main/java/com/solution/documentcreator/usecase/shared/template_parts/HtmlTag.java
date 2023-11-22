package com.solution.documentcreator.usecase.shared.template_parts;

public enum HtmlTag implements DocumentSection {

    DOCTYPE_DECLARATION("<!DOCTYPE html>", ""),
    HTML("<html>", "</html>"),
    HEAD("<head>", "</head>"),
    TITLE("<title>", "</title>"),
    BODY("<body>", "</body>"),
    H1("<h1>", "</h1>"),
    PARAGRAPH("<p>", "</p>"),
    LINK("<a %s>", "</a>"),
    TABLE("<table %s>", "</table>"),
    TABLE_ROW("<tr>", "</tr>"),
    TABLE_DATA("<td>", "</td>");

    private String openingTag;
    private String closingTag;

    HtmlTag(String openingTag, String closingTag) {
        this.openingTag = openingTag;
        this.closingTag = closingTag;
    }

    @Override
    public String getOpeningTag() {
        return this.openingTag;
    }

    @Override
    public String getClosingTag() {
        return this.closingTag;
    }
}
