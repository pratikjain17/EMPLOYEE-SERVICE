package com.pratik.www.employee.service;

import com.pratik.www.employee.db.entity.EmployeeEntity;
import com.pratik.www.employee.db.repository.EmployeeEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    EmployeeEntityRepository employeeRepo;

    public List<EmployeeEntity> getAllEmployees() {
        return employeeRepo.findAll();
    }
    public Optional<EmployeeEntity> getEmployee(String id) {
        return employeeRepo.findById(id);
    }
    public void setEmployee(EmployeeEntity employee) {
        employeeRepo.save(employee);
    }

    public void deleteEmployee(String id) {
        employeeRepo.deleteById(id);
    }
}
