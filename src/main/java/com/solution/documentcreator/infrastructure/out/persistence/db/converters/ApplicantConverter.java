package com.solution.documentcreator.infrastructure.out.persistence.db.converters;

import com.solution.documentcreator.infrastructure.out.persistence.db.entities.ApplicantEntity;
import com.solution.documentcreator.usecase.applicant.find.ports.DsApplicantModel;
import org.springframework.stereotype.Service;

@Service
public class ApplicantConverter implements EntityConverter<ApplicantEntity, DsApplicantModel> {
    @Override
    public ApplicantEntity mapToEntity(DsApplicantModel dsRequest) {
        return new ApplicantEntity(dsRequest.name(), dsRequest.email(), dsRequest.repositoryUrl());
    }

    @Override
    public DsApplicantModel mapToDsResponse(ApplicantEntity entity) {
        return new DsApplicantModel(entity.getName(), entity.getEmail(), entity.getRepositoryUrl());
    }
}
