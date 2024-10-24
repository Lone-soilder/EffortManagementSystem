package com.Lone_soilder.Effort.repository;

import com.Lone_soilder.Effort.entity.Effort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EffortRepository extends JpaRepository<Effort , Long> {

    Optional<Effort> findByEmployee_empId(Long employee);
    List<Effort> findAllByEmployee_EmpId(Long empId);


}
