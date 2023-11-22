package com.solution.documentcreator.usecase.applicant.find;

import com.solution.documentcreator.entities.ApplicantFactory;
import com.solution.documentcreator.usecase.applicant.find.exception.ApplicantNotFoundException;
import com.solution.documentcreator.usecase.applicant.find.ports.ApplicantResponseModel;
import com.solution.documentcreator.usecase.applicant.find.ports.GetApplicantDsGateway;

public class GetApplicantUseCaseImpl implements GetApplicantUseCase {

    private final GetApplicantDsGateway dsGateway;
    private final ApplicantFactory applicantFactory;

    public GetApplicantUseCaseImpl(GetApplicantDsGateway dsGateway, ApplicantFactory applicantFactory) {
        this.dsGateway = dsGateway;
        this.applicantFactory = applicantFactory;
    }

    @Override
    public ApplicantResponseModel findById(long id) {
        var applicant = dsGateway.findById(id)
                .map(resp -> this.applicantFactory.create(resp.name(), resp.email(), resp.repositoryUrl()))
                .orElseThrow(() -> new ApplicantNotFoundException("Applicant with id " + id + " does not exist"));
        return new ApplicantResponseModel(applicant.getName(), applicant.getEmail(), applicant.getRepositoryUrl());
    }
}
