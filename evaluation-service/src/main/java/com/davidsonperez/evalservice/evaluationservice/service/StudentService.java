package com.davidsonperez.evalservice.evaluationservice.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.davidsonperez.evalservice.evaluationservice.data.entity.Student;
import com.davidsonperez.evalservice.evaluationservice.data.repository.StudentRep;

@Service
public class StudentService {
    @Autowired
    StudentRep studentRep;

    public ArrayList<Student> getStudents() {
        return (ArrayList<Student>) studentRep.findAll();
    }

    public Student saveStudentExam(Student student) {
        return studentRep.save(student);
    }
}
