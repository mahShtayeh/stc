package com.stc.employee.controllers;

import com.stc.employee.entities.Employee;
import com.stc.employee.requests.EmployeeRequest;
import com.stc.employee.services.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("employee")
public record EmployeeController(EmployeeService employeeService) {
    @PostMapping
    public void create(@RequestBody EmployeeRequest employeeRequest) {
        employeeService.create(employeeRequest);
    }

    @GetMapping
    public List<Employee> listAll() {
        return employeeService.listAll();
    }

    @PatchMapping("/{id}")
    public void update(@PathVariable String id, @RequestBody EmployeeRequest employeeRequest) {
        employeeService.update(id, employeeRequest);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        employeeService.delete(id);
    }
}
