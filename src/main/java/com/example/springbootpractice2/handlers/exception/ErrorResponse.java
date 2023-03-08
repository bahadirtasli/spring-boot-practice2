package com.example.springbootpractice2.handlers.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

/**
 * Model for Error Response
 *
 * @author Bahadir Tasli
 * @Date 3/8/2023
 */

@Data
@AllArgsConstructor
public class ErrorResponse {
    private String message;
    private List<String> details;
}
