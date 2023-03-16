package com.example.springbootpractice2.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * *School model
 * @author Bahadir Tasli
 * @Date 2/22/2023
 */
@EqualsAndHashCode(callSuper = true)
@Entity
@Data
public class School extends Auditable <String> implements Serializable /*Java.io*/ {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String address;

    private String phone;

    private boolean isActive;
}
