package com.solution.documentcreator.infrastructure.out.persistence.db;

import com.solution.documentcreator.infrastructure.out.persistence.db.converters.ApplicantConverter;
import com.solution.documentcreator.infrastructure.out.persistence.db.repositories.ApplicantRepository;
import com.solution.documentcreator.usecase.applicant.find.ports.DsApplicantModel;
import com.solution.documentcreator.usecase.applicant.find.ports.GetApplicantDsGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GetApplicantDsGatewayImpl implements GetApplicantDsGateway {

    private final ApplicantRepository repository;
    private final ApplicantConverter converter;

    @Autowired
    public GetApplicantDsGatewayImpl(ApplicantRepository repository, ApplicantConverter converter) {
        this.repository = repository;
        this.converter = converter;
    }

    @Override
    public Optional<DsApplicantModel> findById(long id) {
        return this.repository.findById(id)
                .map(this.converter::mapToDsResponse) ;
    }
}
