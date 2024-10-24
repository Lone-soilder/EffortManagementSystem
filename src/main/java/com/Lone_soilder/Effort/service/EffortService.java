package com.Lone_soilder.Effort.service;

import com.Lone_soilder.Effort.entity.Effort;
import com.Lone_soilder.Effort.entity.Employee;
import com.Lone_soilder.Effort.repository.EffortRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class EffortService {

    @Autowired
    EffortRepository effortRepository;
    public List<Effort> getEfforts ( Long empId) {
            List<Effort> efforts = effortRepository.findAllByEmployee_EmpId(empId);
            return efforts;
    }

    public List<Effort> getAllEfforts(){
        return effortRepository.findAll();
    }

    public ResponseEntity<String> addEffort(Effort effort) {
        effortRepository.save(effort);
        return new ResponseEntity<>("Success" , HttpStatus.OK);
    }

    public ResponseEntity<Object> addEfforts(List<Effort> efforts) {
        effortRepository.saveAll(efforts);
        return new ResponseEntity<>("Success" , HttpStatus.OK);
    }
}
