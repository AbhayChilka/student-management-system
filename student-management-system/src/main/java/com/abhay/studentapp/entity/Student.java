package com.abhay.studentapp.entity;

import jakarta.persistence.*;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Entity
@Table(name = "students")
public class Student
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(unique = true, nullable = false, length = 100)
    private String email;

    @Column(nullable = false, length = 20)
    private String rollNo;

    private Double gpa;

    private LocalDate dateOfBirth;

    // Default constructor (required by JPA)
    public Student() {
    }

    // Constructor with parameters
    public Student(String name, String email, String rollNo, Double gpa, LocalDate dateOfBirth) {
        this.name = name;
        this.email = email;
        this.rollNo = rollNo;
        this.gpa = gpa;
        this.dateOfBirth = dateOfBirth;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getRollNo() {
        return rollNo;
    }

    public Double getGpa() {
        return gpa;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", rollNo='" + rollNo + '\'' +
                ", gpa=" + gpa +
                ", dateOfBirth=" + dateOfBirth +
                '}';
    }
}