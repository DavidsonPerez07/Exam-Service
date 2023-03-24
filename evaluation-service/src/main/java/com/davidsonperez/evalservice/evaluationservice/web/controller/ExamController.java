package com.davidsonperez.evalservice.evaluationservice.web.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.davidsonperez.evalservice.evaluationservice.service.ExamService;
import com.davidsonperez.evalservice.evaluationservice.web.dto.ExamDto;

@RestController
@RequestMapping("exam")
public class ExamController {
    private ExamService examService;

    public ExamController(ExamService examService) {
        this.examService = examService;
    }

    @PostMapping()
    public ResponseEntity<?> insert(@RequestBody ExamDto examDto) throws Exception {
        if (examDto == null) {
            return ResponseEntity.badRequest().body("Datos del examen inválidos");
        }

        ExamDto resp;
        try {
            resp = examService.saveExam(examDto);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(resp);
    }
}
