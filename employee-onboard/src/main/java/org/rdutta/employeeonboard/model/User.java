package org.rdutta.employeeonboard.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "USERS")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "EMP_ID", unique = true, nullable = false, updatable = false)
    private UUID user_id;
    @Column(name = "FIRSTNAME", nullable = false, length = 50)
    private String firstname;
    @Column(name = "SURNAME", nullable = false, length = 50)
    private String surname;
    @Column(name = "USERNAME", nullable = false, length = 50)
    private String username;
    @Column(name = "EMAIL", nullable = false, unique = true, length = 150)
    private String email;
    @Column(name = "PHONE", nullable = false, length = 50)
    private String phone;
}
