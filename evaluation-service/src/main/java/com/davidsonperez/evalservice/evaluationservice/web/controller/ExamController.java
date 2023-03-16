package com.davidsonperez.evalservice.evaluationservice.web.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.davidsonperez.evalservice.evaluationservice.data.entity.Exam;
import com.davidsonperez.evalservice.evaluationservice.service.ExamService;

@RestController
@RequestMapping("exam")
public class ExamController {
    @Autowired
    ExamService examService;

    @GetMapping()
    public ArrayList<Exam> getExams() {
        return examService.getExams();
    }

    @PostMapping()
    public Exam saveExam(@RequestBody Exam exam) {
        return this.examService.createExam(exam);
    }
}
