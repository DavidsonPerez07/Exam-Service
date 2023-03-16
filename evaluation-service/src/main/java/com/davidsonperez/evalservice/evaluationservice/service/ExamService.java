package com.davidsonperez.evalservice.evaluationservice.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.davidsonperez.evalservice.evaluationservice.data.entity.Exam;
import com.davidsonperez.evalservice.evaluationservice.data.repository.ExamRep;

@Service
public class ExamService {
    @Autowired
    ExamRep examRep;

    public ArrayList<Exam> getExams() {
        return (ArrayList<Exam>) examRep.findAll();
    }

    public Exam createExam(Exam exam) {
        return examRep.save(exam);
    }
}
