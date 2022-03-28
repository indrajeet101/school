package com.example.school.Services;

import com.example.school.DAO.StudentDAO;
import com.example.school.Models.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{

    StudentDAO studentDAO;
    private static final String[] blackListEmails = new String[]{"blacklist1@gmail.com","blacklist2@gmail.com","blacklist3@gmail.com","blacklist4@gmail.com"};

    @Autowired
    public StudentServiceImpl(@Qualifier("studentDAOImpl") StudentDAO studentDAO1){
        studentDAO = studentDAO1;
    }

    @Override
    @Transactional
    public List<Student> findAllStudents() {
        return studentDAO.getAllStudents();
    }

    @Override
    @Transactional
    public Student findStudentById(int theId) {
        return studentDAO.findStudentById(theId);
    }

    @Override
    @Transactional
    public Student saveStudent(Student theStudent) {
        return studentDAO.saveStudent(theStudent);
    }

    @Override
    @Transactional
    public int deleteStudentById(int theId) {
        studentDAO.deleteStudentId(theId);
        return  theId;
    }
}
