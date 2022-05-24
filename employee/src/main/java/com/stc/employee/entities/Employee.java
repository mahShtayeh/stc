package com.stc.employee.entities;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class Employee {
    private String id;
    private String name;
    private String email;
    private String phone;
}
