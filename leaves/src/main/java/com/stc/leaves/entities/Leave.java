package com.stc.leaves.entities;

import lombok.*;

import javax.persistence.*;
import java.util.List;

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
