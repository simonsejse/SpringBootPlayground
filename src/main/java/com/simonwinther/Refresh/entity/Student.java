package com.simonwinther.Refresh.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Student {
     @Id
     @GeneratedValue(
             strategy = GenerationType.SEQUENCE,
             generator = "student_seq_gen"
     )
     @SequenceGenerator(
             name = "student_seq_gen",
             allocationSize = 1
     )
    private Long id;

    @Column(name="full_name")
    private String fullName;
}
