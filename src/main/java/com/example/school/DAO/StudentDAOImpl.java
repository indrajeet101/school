package com.example.school.DAO;

import com.example.school.Models.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO{

    private EntityManager entityManager;

    @Autowired
    public StudentDAOImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Override
    public List<Student> getAllStudents() {
        Query query = (Query) entityManager.createQuery("from Student");
        List<Student> students = query.getResultList();

        return students;
    }

    @Override
    public Student findStudentById(int theId) {
        Student student = entityManager.find(Student.class, theId);
        return student;
    }

    @Override
    public Student saveStudent(Student theStudent) {
        Student student = entityManager.merge(theStudent);
        student.setId((int) student.getId());
        return student;
    }

    @Override
    public void deleteStudentId(int theId) {
        Query query = (Query) entityManager.createQuery("delete from Student where id = :StudendId");
        query.setParameter("StudentId", theId);
        query.executeUpdate();
    }
}
