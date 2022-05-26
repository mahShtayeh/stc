package com.stc.employee.dtos;

public record EmployeeRequest(
        String name,
        String email,
        String phone) {
}
