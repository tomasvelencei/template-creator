package com.solution.documentcreator.entities;

public sealed interface ApplicantFactory permits ApplicantFactoryImpl {

    Applicant create(String name, String email, String repositoryUri);
}
