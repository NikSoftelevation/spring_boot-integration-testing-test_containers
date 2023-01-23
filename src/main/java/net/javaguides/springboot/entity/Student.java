package net.javaguides.springboot.entity;

import jakarta.persistence.*;
import lombok.*;

/**
 * The type Student.
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="students")
public class Student{
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    private String firstName;
    private String lastName;
    private String email;
}