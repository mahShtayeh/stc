package com.stc.employee.services;

import com.stc.employee.entities.Employee;
import com.stc.employee.repositeries.EmployeeRepository;
import com.stc.employee.requests.EmployeeRequest;
import org.springframework.stereotype.Service;

@Service
public record EmployeeService(EmployeeRepository employeeRepository) {
    public void createEmployee(EmployeeRequest employeeRequest) {
        Employee employee = Employee.builder()
                .name(employeeRequest.name())
                .email(employeeRequest.email())
                .phone(employeeRequest.phone())
                .build();
        employeeRepository.save(employee);
    }
}