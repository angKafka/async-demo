package org.rdutta.passport_automation_system.repository;

import org.rdutta.passport_automation_system.entity.Passport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PassportRepo extends JpaRepository<Passport, UUID> {
}
