package com.example.school.DAO;

import com.example.school.Models.Student;

import java.util.List;

public interface StudentDAO {

    List<Student> getAllStudents();

    Student findStudentById(int theId);

    Student saveStudent(Student theStudent);

    void deleteStudentId(int theId);
}
