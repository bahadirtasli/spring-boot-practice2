package com.example.springbootpractice2.handlers.exception;

import com.example.springbootpractice2.exceptions.SchoolNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Handler for Exceptions
 *
 * @author Bahadir Tasli
 * @Date 3/8/2023
 */
@RestControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handleAllExceptions(Exception e){
        List<String> details = Collections.singletonList(e.getLocalizedMessage());
        ErrorResponse errorResponse = new ErrorResponse("Server Error", details);
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(SchoolNotFoundException.class)
    public final ResponseEntity<Object> handleSchoolNotFoundException(Exception e) {
        List<String> details = Collections.singletonList(e.getLocalizedMessage());
        ErrorResponse errorResponse = new ErrorResponse("School not found!", details);
        return new ResponseEntity<>(errorResponse,HttpStatus.NOT_FOUND);
    }
}
