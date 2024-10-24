package com.Lone_soilder.Effort.repository;

import com.Lone_soilder.Effort.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LoginRepository extends JpaRepository<Employee, Long> {

    Optional<Employee> findByUsername(String username);
}
