package com.Lone_soilder.Effort.controller;

import com.Lone_soilder.Effort.entity.Employee;

import com.Lone_soilder.Effort.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/effort")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @GetMapping("/getEmp")
    public ResponseEntity<Optional<Employee>> getUser(@RequestParam String username){
        return loginService.findEmpByUsername(username);
    }

    @CrossOrigin(origins = "http://127.0.0.1:5500")
    @PostMapping(value = "/addEmp",  consumes = {"application/json"})
    public ResponseEntity<String> addEmployee(@RequestBody List<Employee> employees){

         if(loginService.logging((List<Employee>) employees).getStatusCode().is2xxSuccessful()){
             return ResponseEntity
                     .status(HttpStatus.OK)
                     .body("login success");
         }
         else {
             return ResponseEntity
                     .status(HttpStatus.UNAUTHORIZED)
                     .body("Login failed");
         }
    }

}
