package org.rdutta.passport_automation_system.dao;

import org.rdutta.passport_automation_system.entity.Applicant;
import org.rdutta.passport_automation_system.entity.Application;

public interface PassportApply {
    String applyForPassport(Integer application_id, Integer applicant_id);
}
