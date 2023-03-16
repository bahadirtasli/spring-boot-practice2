package com.example.springbootpractice2.repositories;

import com.example.springbootpractice2.models.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Repository to handle all Teacher related DB operations
 *
 * @author Bahadir Tasli
 * @Date 2/22/2023
 */
@Repository
public interface TeacherRepository extends JpaRepository<Teacher,Long> {
    Optional<Teacher> findByName(String name);
}
