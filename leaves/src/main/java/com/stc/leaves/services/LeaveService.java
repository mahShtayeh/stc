package com.stc.leaves.services;

import com.stc.leaves.entities.Leave;
import com.stc.leaves.repositories.LeaveRepository;
import com.stc.leaves.requests.LeaveRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public record LeaveService(LeaveRepository leaveRepository) {
    public void create(LeaveRequest leaveRequest) {
        Leave leave = Leave.builder()
                .employeeId(leaveRequest.employeeId())
                .paid(leaveRequest.paid())
                .build();
        leaveRepository.save(leave);
    }

    public List<Leave> listAll() {
        return leaveRepository.findAll();
    }

    public void update(Integer id, LeaveRequest leaveRequest) {
        Leave leave = leaveRepository.getById(id);
        leave.setEmployeeId(leaveRequest.employeeId());
        leave.setPaid(leaveRequest.paid());
        leaveRepository.save(leave);
    }

    public void delete(Integer id) {
        leaveRepository.deleteById(id);
    }
}