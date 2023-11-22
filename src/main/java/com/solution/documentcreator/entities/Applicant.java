package com.solution.documentcreator.entities;

public sealed interface Applicant permits ApplicantImpl {

    String getName();

    String getEmail();

    String getRepositoryUrl();

}
