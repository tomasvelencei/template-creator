package com.solution.documentcreator.usecase.applicant.find.ports;

import java.util.Optional;

public interface GetApplicantDsGateway {
    Optional<DsApplicantModel> findById(long id);
}
