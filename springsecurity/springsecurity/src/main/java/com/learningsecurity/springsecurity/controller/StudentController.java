package com.learningsecurity.springsecurity.controller;


import com.learningsecurity.springsecurity.model.Student;
import com.learningsecurity.springsecurity.service.StudentService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpRequest;
import java.util.ArrayList;
import java.util.List;

@RestController

public class StudentController {

    private String students(){
        return "Hello Students";
    }

    @Autowired
    private StudentService studentService;

        @GetMapping("/students")
        public ResponseEntity<?> getAllStudents() {
            return new ResponseEntity<>(studentService.getAllStudents(), HttpStatus.OK);
        }


        @PostMapping("/students")
        public ResponseEntity<?> addStudent(@RequestBody Student student) {
            return new ResponseEntity<>(studentService.addStudent(student), HttpStatus.CREATED);
        }

        @DeleteMapping("/students/{rollNo}")
    private ResponseEntity<?> deleteStudent(@PathVariable Integer rollNo) {
            return new ResponseEntity<>(studentService.deleteStudent(rollNo),HttpStatus.OK);
        }
}
