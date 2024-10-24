package com.Lone_soilder.Effort.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;

import java.util.Set;


@Entity
@Data
public class Employee {

    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long empId;

    @Column
    private String username;
    @Column
    private String password;

    @Column
    private String role;

    /* @OneToMany(mappedBy = "employee"):
    Defines a one-to-many relationship.
    The mappedBy attribute indicates that the Effort entity owns the relationship
    (the Effort entity has a field named employee which is the foreign key).
     */
    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Effort> efforts;

    public void setEmpId(Long empId) {
        this.empId = empId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
