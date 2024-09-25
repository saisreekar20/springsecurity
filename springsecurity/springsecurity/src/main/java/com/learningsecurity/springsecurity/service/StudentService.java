package com.learningsecurity.springsecurity.service;

import com.learningsecurity.springsecurity.model.Student;


import com.learningsecurity.springsecurity.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepo studentRepo;

    public List<Student> getAllStudents() {
        return studentRepo.findAll();
    }

    public Student addStudent(Student student) {
        studentRepo.save(student);
        return student;
    }

    public List<Student> deleteStudent(Integer rollNo) {
        studentRepo.deleteById(rollNo);
        return studentRepo.findAll();
    }
}
