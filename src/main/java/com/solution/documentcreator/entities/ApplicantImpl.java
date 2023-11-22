package com.solution.documentcreator.entities;

import java.util.Objects;

public final class ApplicantImpl implements Applicant {

    private String name;
    private String email;
    private String repositoryUrl;

    ApplicantImpl(String name, String email, String repositoryUrl) {
        this.name = name;
        this.email = email;
        this.repositoryUrl = repositoryUrl;
    }

    public String getName() {
        return this.name;
    }

    public String getEmail() {
        return this.email;
    }

    public String getRepositoryUrl() {
        return this.repositoryUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ApplicantImpl applicant = (ApplicantImpl) o;
        return Objects.equals(getName(), applicant.getName())
                    && Objects.equals(getEmail(), applicant.getEmail())
                    && Objects.equals(getRepositoryUrl(), applicant.getRepositoryUrl());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getEmail(), getRepositoryUrl());
    }
}
