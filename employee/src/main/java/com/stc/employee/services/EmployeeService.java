package com.stc.employee.services;

import com.stc.employee.dtos.EmployeeLeaveResponse;
import com.stc.employee.entities.Employee;
import com.stc.employee.repositeries.EmployeeRepository;
import com.stc.employee.dtos.EmployeeRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public void create(EmployeeRequest employeeRequest) {
        Employee employee = Employee.builder()
                .name(employeeRequest.name())
                .email(employeeRequest.email())
                .phone(employeeRequest.phone())
                .build();
        employeeRepository.save(employee);
    }

    public List<Employee> listAll() {
        return employeeRepository.findAll();
    }

    public void update(String id, EmployeeRequest employeeRequest) {
        Employee employee = employeeRepository.getById(id);
        employee.setName(employeeRequest.name());
        employee.setEmail(employeeRequest.email());
        employee.setPhone(employeeRequest.phone());
        employeeRepository.save(employee);
    }

    public void delete(String id) {
        employeeRepository.deleteById(id);
    }

    public Employee getOne(String id) {
        return employeeRepository.getById(id);
    }

    public List<EmployeeLeaveResponse> fetch() {
        List<Employee> employees = employeeRepository.findAll();
        List<EmployeeLeaveResponse> employeeLeaveResponseList = employees.stream()
                .map(employee -> EmployeeLeaveResponse.builder().id(employee.getId())
                        .name(employee.getName())
                        .leavesNum(employee.getLeaves().size())
                        .build()).toList();

        return employeeLeaveResponseList;
    }
}