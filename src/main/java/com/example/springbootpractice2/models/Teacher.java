package com.example.springbootpractice2.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.List;

/**
 * Teacher model
 * @author Bahadir Tasli
 * @Date 2/22/2023
 */
@EqualsAndHashCode(callSuper = true)
@Entity
@Data
public class Teacher extends Auditable <String> implements Serializable /*Java.io*/ {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    private String email;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Course> specializedCourses;



}
