package com.davidsonperez.evalservice.evaluationservice.web.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.davidsonperez.evalservice.evaluationservice.data.entity.Student;
import com.davidsonperez.evalservice.evaluationservice.service.StudentService;

@RestController
@RequestMapping("student")
public class StudentController {
    @Autowired
    StudentService studentService;

    @GetMapping()
    public ArrayList<Student> getStudents() {
        return studentService.getStudents();
    }

    @PostMapping()
    public Student saveStudent(@RequestBody Student student) {
        return this.studentService.saveStudentExam(student);
    }
}
