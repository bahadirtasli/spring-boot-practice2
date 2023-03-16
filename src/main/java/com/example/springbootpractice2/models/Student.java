package com.example.springbootpractice2.models;


import lombok.Data;
import lombok.EqualsAndHashCode;
import jakarta.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Student model
 * @author Bahadir Tasli
 * @Date 2/22/2023
 */
@EqualsAndHashCode(callSuper = true)
@Entity
@Data
public class Student extends Auditable <String> implements Serializable /*Java.io*/ {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private int age;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    private String email;

    private float grade;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Course> courses;

    private boolean isActive;


}
