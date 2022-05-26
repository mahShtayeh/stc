package com.stc.leaves.entities;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Employee {
    @Id
    @GeneratedValue(generator = "employee_id_generator")
    @GenericGenerator(name = "employee_id_generator", strategy = "uuid2")
    @Column(name = "id")
    private String id;
    private String name;
    private String email;
    private String phone;
}
