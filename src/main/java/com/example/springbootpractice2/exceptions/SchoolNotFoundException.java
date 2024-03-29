package com.example.springbootpractice2.exceptions;

import java.util.UUID;

/**
 * Exception for the school not found
 *
 * @author Bahadir Tasli
 * @Date 2/27/2023
 */
public class SchoolNotFoundException extends Exception {
    private static final long serialVersionUID = 1L;

    public SchoolNotFoundException(Long id) {
        super(String.format("School not found for id: %d", id));
    }

    public SchoolNotFoundException(String name) {
        super(String.format("School not found for name: %s", name));
    }


}