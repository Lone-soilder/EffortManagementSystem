package com.Lone_soilder.Effort.controller;

import com.Lone_soilder.Effort.entity.Effort;
import com.Lone_soilder.Effort.entity.Employee;
import com.Lone_soilder.Effort.service.EffortService;
import com.Lone_soilder.Effort.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("effort")
public class EffortController {
    @Autowired
    EffortService effortService;

    @Autowired
    LoginService loginService;


    @GetMapping("/allEffort")
    public ResponseEntity<List<Effort>> getAllEfforts(){
        List<Effort> efforts = effortService.getAllEfforts();
        if (!efforts.isEmpty()) {
            return new ResponseEntity<>(efforts, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
    @GetMapping("/{empId}/myEffort")
    public ResponseEntity<List<Effort>> getEffortOfEmp(@PathVariable Long empId){
        Optional<Employee> employee = loginService.findEmpById(empId).getBody();

        if (employee.isPresent()){
            List<Effort> efforts = effortService.getEfforts(employee.get().getEmpId());
            if (!efforts.isEmpty()) {
                return new ResponseEntity<>(efforts, HttpStatus.OK);  // Return the efforts list
            }
            else {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT); // No efforts found
            }

        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/addEfforts")
    public ResponseEntity<String> addEfforts(@RequestBody List<Effort> efforts){

        if (effortService.addEfforts(efforts).getStatusCode().is2xxSuccessful()){
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body("efforts added successfully");
        }
        else {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("wrong effort");
        }
    }

    @PostMapping("/addEffort")
    public ResponseEntity<String> addEffort(@RequestBody Effort effort){
        if (effortService.addEffort(effort).getStatusCode().is2xxSuccessful()){
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body("effort added for EmpID - "+ effort.getEffortId());
        }
        else {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("wrong effort");
        }
    }
}
