package com.stc.employee.controllers;

import com.stc.employee.requests.EmployeeRequest;
import com.stc.employee.services.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("employee")
public record EmployeeController(EmployeeService employeeService) {
    @PostMapping
    public void createEmployee(@RequestBody EmployeeRequest employeeRequest) {
        employeeService.createEmployee(employeeRequest);
    }
}
