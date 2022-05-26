package com.stc.leaves.services;

import com.stc.leaves.entities.Employee;
import com.stc.leaves.entities.Leave;
import com.stc.leaves.repositories.LeaveRepository;
import com.stc.leaves.dtos.LeaveRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@AllArgsConstructor
public class LeaveService {
    private final LeaveRepository leaveRepository;
    private final RestTemplate restTemplate;

    public void create(LeaveRequest leaveRequest) {
        Employee employee = restTemplate.getForObject(
                "http://localhost:8080/employee/{id}",
                Employee.class,
                leaveRequest.employeeId()
        );
        Leave leave = Leave.builder()
                .employee(employee)
                .paid(leaveRequest.paid())
                .build();
        leaveRepository.save(leave);
    }

    public List<Leave> listAll() {
        return leaveRepository.findAll();
    }

    public void update(Integer id, LeaveRequest leaveRequest) {
        Employee employee = restTemplate.getForObject(
                "http://localhost:8080/employee/{id}",
                Employee.class,
                leaveRequest.employeeId()
        );
        Leave leave = leaveRepository.getById(id);
        leave.setEmployee(employee);
        leave.setPaid(leaveRequest.paid());
        leaveRepository.save(leave);
    }

    public void delete(Integer id) {
        leaveRepository.deleteById(id);
    }
}