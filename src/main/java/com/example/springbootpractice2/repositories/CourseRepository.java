package com.example.springbootpractice2.repositories;

import com.example.springbootpractice2.models.Course;
import com.example.springbootpractice2.models.School;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Repository to handle all Course related DB operations
 *
 * @author Bahadir Tasli
 * @Date 2/22/2023
 */

@Repository
public interface CourseRepository extends JpaRepository<Course,Long> {
    Optional<Course> findByName(String name);

    List<Course> findAllBySchool(School school);


}
