package com.davidsonperez.evalservice.evaluationservice.web.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.davidsonperez.evalservice.evaluationservice.service.StudentService;
import com.davidsonperez.evalservice.evaluationservice.web.dto.StudentDto;

@RestController
@RequestMapping("student")
public class StudentController {
    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping()
    public ResponseEntity<?> insertStudent(@RequestBody StudentDto studentDto) throws Exception {
        if (studentDto == null) {
            return ResponseEntity.badRequest().body("Datos del estudiante inválidos");
        }

        StudentDto resp;
        try {
            resp = studentService.saveStudent(studentDto);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(resp);
    }
}
