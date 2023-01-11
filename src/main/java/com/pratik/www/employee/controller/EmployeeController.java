package com.pratik.www.employee.controller;

import com.pratik.www.employee.db.entity.EmployeeEntity;
import com.pratik.www.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/employees")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @GetMapping("/all")
    public List<EmployeeEntity> getAllEmployees(){
        return this.employeeService.getAllEmployees();
    }
    //
    @GetMapping("/{employeeId}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<EmployeeEntity> getEmployee(@PathVariable("employeeId") String id){
        return this.employeeService.getEmployee(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public void setEmployee(@RequestBody EmployeeEntity employee){
        this.employeeService.setEmployee(employee);
    }

    @DeleteMapping("/{employeeId}")
    public void deleteEmployee(@PathVariable("empId") String id) {
        employeeService.deleteEmployee(id);
    }
}
