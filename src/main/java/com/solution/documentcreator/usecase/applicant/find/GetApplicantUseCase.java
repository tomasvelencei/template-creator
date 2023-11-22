package com.solution.documentcreator.usecase.applicant.find;

import com.solution.documentcreator.usecase.applicant.find.ports.ApplicantResponseModel;

public interface GetApplicantUseCase {

    ApplicantResponseModel findById(long id);
}
