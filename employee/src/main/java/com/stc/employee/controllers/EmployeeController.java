package com.stc.employee.controllers;

import com.stc.employee.dtos.EmployeeLeaveResponse;
import com.stc.employee.entities.Employee;
import com.stc.employee.dtos.EmployeeRequest;
import com.stc.employee.services.EmployeeService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("employee")
@AllArgsConstructor
public class EmployeeController {
    private final EmployeeService employeeService;

    @PostMapping
    public void create(@RequestBody EmployeeRequest employeeRequest) {
        employeeService.create(employeeRequest);
    }

    @GetMapping
    public List<Employee> listAll() {
        return employeeService.listAll();
    }

    @GetMapping("/{id}")
    public Employee getOne(@PathVariable String id) {
        return employeeService.getOne(id);
    }

    @PatchMapping("/{id}")
    public void update(@PathVariable String id, @RequestBody EmployeeRequest employeeRequest) {
        employeeService.update(id, employeeRequest);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        employeeService.delete(id);
    }

    @GetMapping("/fetch")
    public List<EmployeeLeaveResponse> fetch() {
        return employeeService.fetch();
    }
}
