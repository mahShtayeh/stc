package com.stc.employee.requests;

public record EmployeeRequest(
        String name,
        String email,
        String phone) {
}
