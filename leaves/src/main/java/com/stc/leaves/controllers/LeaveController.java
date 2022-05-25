package com.stc.leaves.controllers;

import com.stc.leaves.entities.Leave;
import com.stc.leaves.dtos.EmployeeLeaveResponse;
import com.stc.leaves.dtos.LeaveRequest;
import com.stc.leaves.services.LeaveService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("employee-leave")
@AllArgsConstructor
public class LeaveController {
    private final LeaveService leaveService;

    @PostMapping
    public void create(@RequestBody LeaveRequest leaveRequest) {
        leaveService.create(leaveRequest);
    }

    @GetMapping
    public List<Leave> listAll() {
        return leaveService.listAll();
    }

    @PatchMapping("/{id}")
    public void update(@PathVariable Integer id, @RequestBody LeaveRequest leaveRequest) {
        leaveService.update(id, leaveRequest);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        leaveService.delete(id);
    }

    @GetMapping("/fetch")
    public List<EmployeeLeaveResponse> fetchLeaves() {
        return leaveService.fetch();
    }
}
