package com.example.springbootpractice2.repositories;

import com.example.springbootpractice2.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Repository to handle all Student related DB operations
 *
 * @author Bahadir Tasli
 * @Date 2/22/2023
 */
@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {
    Optional<Student> findByName(String name);
}
