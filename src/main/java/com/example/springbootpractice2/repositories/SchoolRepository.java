package com.example.springbootpractice2.repositories;

import com.example.springbootpractice2.models.School;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Repository to handle all School related DB operations
 *
 * @author Bahadir Tasli
 * @Date 2/22/2023
 */
@Repository
public interface SchoolRepository extends JpaRepository<School,Long> {
    Optional<School> findByName(String name);
}
