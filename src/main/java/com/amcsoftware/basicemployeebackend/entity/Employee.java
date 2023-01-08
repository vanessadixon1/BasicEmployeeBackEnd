package com.amcsoftware.basicemployeebackend.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Employee")
@Table(
        name = "employee",
        uniqueConstraints = {
                @UniqueConstraint(name = "employee_email_unique", columnNames = "email"),
                @UniqueConstraint(name = "employee_code_unique", columnNames = "employee_code")
        }
)
public class Employee {
    @Id
    @SequenceGenerator(
            name = "employee_sequence",
            sequenceName = "employee_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.AUTO,
            generator = "employee_sequence"
    )
    @Column(
            name = "id",
            updatable = false
    )
    private Long id;
    @Column(
            name = "name",
            nullable = false
    )
    private String name;
    @Column(
            name = "email",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String email;
    @Column(
            name = "job_title",
            nullable = false)
    private String jobTitle;
    @Column(
            name = "phone",
            nullable = false)
    private String phone;
    @Column(
            name = "image_url",
            nullable = false)
    private String imageUrl;
    @Column(
            name = "employee_code",
            nullable = false)
    private String employeeCode;
}
