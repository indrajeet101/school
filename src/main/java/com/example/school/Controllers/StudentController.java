package com.example.school.Controllers;

import com.example.school.Models.Student;
import com.example.school.Services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/school")
public class StudentController {

    private StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService1){
        studentService = studentService1;
    }

    @RequestMapping(value = "/students", method = RequestMethod.GET)
    public ResponseEntity<List<Student>> findAll(){
        return new ResponseEntity<List<Student>>(studentService.findAllStudents(), HttpStatus.OK);
    }

    @RequestMapping(value = "/students/{studentId}", method = RequestMethod.GET)
    public Student getStudent(@PathVariable int studentId){
        Student student = studentService.findStudentById(studentId);
        return student;
    }

    @RequestMapping(value = "/students", method = RequestMethod.POST)
    public Student addStudent(@RequestBody Student student){
        return studentService.saveStudent(student);
    }

    @RequestMapping(value = "/students/{studentId}", method = RequestMethod.DELETE)
    public String deleteStudent(@PathVariable int studentId){
        Student tempStudent = studentService.findStudentById(studentId);
        if (tempStudent == null){
            throw new RuntimeException("Student ID not found");
        }
        studentService.deleteStudentById(studentId);
        return "Deleted Student id "+ studentId;
    }

}
