package com.Lone_soilder.Effort.service;

import com.Lone_soilder.Effort.entity.Employee;
import com.Lone_soilder.Effort.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LoginService {
    @Autowired
    private LoginRepository loginRepository;

    public ResponseEntity<String> logging(List<Employee> employees) {
         loginRepository.saveAll(employees);
         return new ResponseEntity<>("Success", HttpStatus.OK);
    }

    public ResponseEntity<Optional<Employee>> findEmpById(Long empId) {

        Optional<Employee> employee = loginRepository.findById(empId);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(employee);
    }

    public ResponseEntity<List<Employee>> getAllEmployee() {

        List<Employee> employees = loginRepository.findAll();

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(employees);
//        return new ResponseEntity<>(employees, HttpStatus.OK );
    }

    public ResponseEntity<Optional<Employee>> findEmpByUsername(String username) {

        Optional<Employee> employee =  loginRepository.findByUsername(username);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(employee);
    }
}
