package com.example.school.Services;

import com.example.school.Models.Student;

import java.util.List;

public interface StudentService {

    public List<Student> findAllStudents();

    public Student findStudentById(int theId);

    public Student saveStudent(Student theStudent);

    public int deleteStudentById(int theId);
}
