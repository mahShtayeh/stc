package com.stc.leaves.dtos;

public record LeaveRequest(
        String employeeId,
        Boolean paid
) {
}
