package com.solution.documentcreator.infrastructure.out.persistence.db.repositories;

import com.solution.documentcreator.infrastructure.out.persistence.db.entities.ApplicantEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicantRepository  extends JpaRepository<ApplicantEntity, Long> {
}
