package org.rdutta.localaccounts.repository;

import org.rdutta.localaccounts.entities.sso.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<Users, UUID> {
    Optional<Users> findByEmail(String email);
    Boolean existsByEmail(String email);
}
