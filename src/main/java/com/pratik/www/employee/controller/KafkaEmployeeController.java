package com.pratik.www.employee.controller;

import com.pratik.www.employee.db.entity.EmployeeEntity;
import com.pratik.www.employee.service.EmployeeProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value = "kafka/employees")
public class KafkaEmployeeController {
    @Autowired
    private EmployeeProducer employeeProducer;

    @GetMapping("/{employeeId}")
    @ResponseStatus(HttpStatus.OK)
    public void getEmployee(@PathVariable("employeeId") String id){
         employeeProducer.sendMessage(id);
    }
}
