package com.abhay.studentapp.repository;

import com.abhay.studentapp.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    // Custom finder methods
    Optional<Student> findByEmail(String email);

    List<Student> findByNameContainingIgnoreCase(String name);

    boolean existsByRollNo(String rollNo);
}