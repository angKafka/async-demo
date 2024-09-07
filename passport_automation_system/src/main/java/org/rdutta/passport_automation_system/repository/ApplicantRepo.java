package org.rdutta.passport_automation_system.repository;

import org.rdutta.passport_automation_system.entity.Applicant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicantRepo extends JpaRepository<Applicant, Integer> {
}
