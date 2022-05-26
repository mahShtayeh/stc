package com.stc.employee.dtos;

import lombok.*;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeLeaveResponse {
    private String id;
    private String name;
    private Integer leavesNum;
}
