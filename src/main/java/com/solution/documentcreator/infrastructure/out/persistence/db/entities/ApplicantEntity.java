package com.solution.documentcreator.infrastructure.out.persistence.db.entities;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "applicant")
public class ApplicantEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "repository_url")
    private String repositoryUrl;

    public ApplicantEntity() {
    }

    public ApplicantEntity(String name, String email, String repositoryUrl) {
        this.name = name;
        this.email = email;
        this.repositoryUrl = repositoryUrl;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRepositoryUrl() {
        return repositoryUrl;
    }

    public void setRepositoryUrl(String repositoryUrl) {
        this.repositoryUrl = repositoryUrl;
    }
}
