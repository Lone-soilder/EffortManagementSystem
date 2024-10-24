package com.Lone_soilder.Effort.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Data
public class Effort {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long effortId;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @Column
    private String location;

    @Column
    private String task;

    @Column
    private int hours;

    /* @JoinColumn(name = "employee_id", nullable = false)
    : Specifies the foreign key column in the Effort table that links to the Employee table.
    The name = "employee_id" part explicitly sets the column name for the foreign key in the Effort table.*/
    @ManyToOne
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee employee;

}
