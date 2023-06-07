package com.davidsonperez.evalservice.evaluationservice.web.controller;

<<<<<<< HEAD
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
=======
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
>>>>>>> 94d946e40a3448eadd9de50de2fec81ce4757f89
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.davidsonperez.evalservice.evaluationservice.service.ExamService;
import com.davidsonperez.evalservice.evaluationservice.web.dto.ExamDto;
<<<<<<< HEAD

@RestController
@RequestMapping("exam")
@CrossOrigin(origins = "http://localhost:4200")
=======
import com.davidsonperez.evalservice.evaluationservice.web.dto.OptionDto;
import com.davidsonperez.evalservice.evaluationservice.web.dto.QuestionDto;

@RestController
@RequestMapping("exam")
>>>>>>> 94d946e40a3448eadd9de50de2fec81ce4757f89
public class ExamController {
    private ExamService examService;

    public ExamController(ExamService examService) {
        this.examService = examService;
    }

    @PostMapping("/saveExam")
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

    @GetMapping("/getExam")
    public ResponseEntity<?> showExam(@RequestParam Long idExam) {
        ExamDto resp;
        resp = examService.getExam(idExam);

        if (resp == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Este examen no existe");
        }

        return ResponseEntity.ok(resp);
    }

<<<<<<< HEAD
    @DeleteMapping("/deleteExam")
    public ResponseEntity<?> deleteExam(@RequestParam Long idExam) {
        Boolean resp;

        resp = examService.deleteExam(idExam);

        if (resp == false) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Este examen no existe");
        }

        return ResponseEntity.ok().build();
    }

    @GetMapping("/getAllExams")
    public ResponseEntity<?> showAllExams() {
        List<ExamDto> examDtos = examService.getAllExams();

        return ResponseEntity.ok(examDtos);
=======
    @PostMapping("/saveQuestion")
    public ResponseEntity<?> insertQuestion(@RequestBody QuestionDto questionDto) throws Exception {
        if (questionDto == null) {
            return ResponseEntity.badRequest().body("Datos de la pregunta inválidos");
        }

        QuestionDto resp;
        try {
            resp = examService.saveQuestion(questionDto);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(resp);
    }

    @PostMapping("/saveOption")
    public ResponseEntity<?> insertOption(@RequestBody OptionDto optionDto, @RequestParam Long idQuestion) throws Exception {
        if (optionDto == null) {
            return ResponseEntity.badRequest().body("Datos de la opción inválidos");
        }

        OptionDto resp;
        try {
            resp = examService.saveOption(optionDto, idQuestion);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(resp);
>>>>>>> 94d946e40a3448eadd9de50de2fec81ce4757f89
    }
}
