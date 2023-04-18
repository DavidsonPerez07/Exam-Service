package com.davidsonperez.evalservice.evaluationservice.web.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.davidsonperez.evalservice.evaluationservice.service.ExamService;
import com.davidsonperez.evalservice.evaluationservice.web.dto.ExamDto;
import com.davidsonperez.evalservice.evaluationservice.web.dto.OptionDto;
import com.davidsonperez.evalservice.evaluationservice.web.dto.QuestionDto;

@RestController
@RequestMapping("exam")
public class ExamController {
    private ExamService examService;

    public ExamController(ExamService examService) {
        this.examService = examService;
    }

    @PostMapping()
    public ResponseEntity<?> insertExam(@RequestBody ExamDto examDto) throws Exception {
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

    @PostMapping("/saveQuestions")
    public ResponseEntity<?> insertQuestions(@RequestBody List<QuestionDto> questionDtos) throws Exception {
        for (int i = 0; i < questionDtos.size(); i++) {
            if (questionDtos.get(i) == null) {
                return ResponseEntity.badRequest().body("Datos de la pregunta inválidos");
            }
        }

        List<QuestionDto> resp;
        try {
            resp = examService.saveQuestions(questionDtos);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(resp);
    }

    @PostMapping("/saveOptions")
    public ResponseEntity<?> insertOptions(@RequestBody List<OptionDto> optionDtos) throws Exception {
        for (int i = 0; i < optionDtos.size(); i++) {
            if (optionDtos.get(i) == null) {
                return ResponseEntity.badRequest().body("Datos de la pregunta inválidos");
            }
        }

        List<OptionDto> resp;
        try {
            resp = examService.saveOptions(optionDtos);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(resp);
    }

    @PostMapping("/saveOption")
    public ResponseEntity<?> insertOption(@RequestBody OptionDto optionDto) throws Exception {
        if (optionDto == null) {
            return ResponseEntity.badRequest().body("Datos de la opción inválidos");
        }

        OptionDto resp;
        try {
            resp = examService.saveOption(optionDto);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(resp);
    }
}
