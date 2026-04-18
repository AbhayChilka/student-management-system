package com.abhay.studentapp.service;

import com.abhay.studentapp.entity.Student;
import com.abhay.studentapp.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StudentService
{
    @Autowired
    private StudentRepository studentRepository;

    // Get all students
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    // Get student by ID
    public Student getStudentById(Long id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found with id: " + id));
    }

    // Create new student with validation
    public Student createStudent(Student student) {
        // Validation: check if email already exists
        if (studentRepository.findByEmail(student.getEmail()).isPresent()) {
            throw new IllegalArgumentException("Email already registered");
        }

        // Validation: check if roll number already exists
        if (studentRepository.existsByRollNo(student.getRollNo())) {
            throw new IllegalArgumentException("Roll number already exists");
        }

        // Validation: check GPA is valid
        if (student.getGpa() != null && (student.getGpa() < 0 || student.getGpa() > 4)) {
            throw new IllegalArgumentException("GPA must be between 0 and 4");
        }

        // Validation: check name is not empty
        if (student.getName() == null || student.getName().trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }

        return studentRepository.save(student);
    }

    // Update student
    public Student updateStudent(Long id, Student studentDetails) {
        Student student = getStudentById(id);

        student.setName(studentDetails.getName());
        student.setEmail(studentDetails.getEmail());
        student.setRollNo(studentDetails.getRollNo());
        student.setGpa(studentDetails.getGpa());
        student.setDateOfBirth(studentDetails.getDateOfBirth());

        return studentRepository.save(student);
    }

    // Delete student
    public void deleteStudent(Long id) {
        if (!studentRepository.existsById(id)) {
            throw new RuntimeException("Student not found with id: " + id);
        }
        studentRepository.deleteById(id);
    }

    // Search by name
    public List<Student> searchByName(String name) {
        return studentRepository.findByNameContainingIgnoreCase(name);
    }
}