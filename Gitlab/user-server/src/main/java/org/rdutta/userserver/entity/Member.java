package org.rdutta.userserver.entity;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "MEMBERS")
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "MEMBER_ID")
    private UUID member_id;
    @Column(name = "USERNAME")
    private String username;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "PASSWORD")
    private String password;
    @Column(name = "ACTIVE")
    private int active;

    public Member() {}

    public Member(String username, String email, String password, int active) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.active = active;
    }

    public UUID getMember_id() {
        return member_id;
    }

    public void setMember_id(UUID member_id) {
        this.member_id = member_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "Member{" +
                "member_id=" + member_id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", active=" + active +
                '}';
    }
}
