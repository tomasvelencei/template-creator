package com.solution.documentcreator.entities;

public final class ApplicantFactoryImpl implements ApplicantFactory {

    @Override
    public Applicant create(String name, String email, String repositoryUri) {
        return new ApplicantImpl(name, email, repositoryUri);
    }
}
