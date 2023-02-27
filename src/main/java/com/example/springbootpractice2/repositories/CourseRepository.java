package com.example.springbootpractice2.repositories;

import com.example.springbootpractice2.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository to handle all Course related DB operations
 *
 * @author Bahadir Tasli
 * @Date 2/22/2023
 */

@Repository
public interface CourseRepository extends JpaRepository<Course,Long> {

}
