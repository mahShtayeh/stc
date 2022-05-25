package com.stc.leaves.requests;

public record LeaveRequest(
        String employeeId,
        Boolean paid
) {
}
