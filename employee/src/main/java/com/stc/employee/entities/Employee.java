package com.stc.employee.entities;

import lombok.*;

import javax.persistence.*;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Employee {
    @Id
    @SequenceGenerator(
            name = "employee_id_sequence",
            sequenceName = "employee_id_sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "employee_id_sequence"
    )
    private String id;
    private String name;
    private String email;
    private String phone;
}
