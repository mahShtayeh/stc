package com.stc.employee.entities;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Leave {
    @Id
    @SequenceGenerator(
            name = "leave_id_sequence",
            sequenceName = "leave_id_sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "leave_id_sequence"
    )
    private Integer id;

    @ManyToOne
    private Employee employee;
    private Boolean paid;
}
