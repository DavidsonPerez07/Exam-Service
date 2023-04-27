package com.davidsonperez.evalservice.evaluationservice.service;

import org.springframework.stereotype.Service;

import com.davidsonperez.evalservice.evaluationservice.data.entity.Answer;
import com.davidsonperez.evalservice.evaluationservice.data.entity.ExamPresentation;
import com.davidsonperez.evalservice.evaluationservice.data.repository.AnswerRepository;
import com.davidsonperez.evalservice.evaluationservice.data.repository.ExamPresentationRepository;
import com.davidsonperez.evalservice.evaluationservice.data.repository.ExamRepository;
import com.davidsonperez.evalservice.evaluationservice.data.repository.OptionRepository;
import com.davidsonperez.evalservice.evaluationservice.data.repository.QuestionRepository;
import com.davidsonperez.evalservice.evaluationservice.data.repository.StudentRepository;
import com.davidsonperez.evalservice.evaluationservice.web.dto.ExamPresentationDto;

@Service
public class ExamPresentationService {
    private ExamPresentationRepository examPresentationRepository;
    private ExamRepository examRepository;
    private AnswerRepository answerRepository;
    private QuestionRepository questionRepository;
    private OptionRepository optionRepository;
    private StudentRepository studentRepository;
    
    public ExamPresentationService(ExamPresentationRepository examPresentationRepository, ExamRepository examRepository, 
    AnswerRepository answerRepository, QuestionRepository questionRepository, OptionRepository optionRepository, 
    StudentRepository studentRepository) {
        this.examPresentationRepository = examPresentationRepository;
        this.examRepository = examRepository;
        this.answerRepository = answerRepository;
        this.questionRepository = questionRepository;
        this.optionRepository = optionRepository;
        this.studentRepository = studentRepository;
    }

    /*public ExamPresentationDto takeExam(ExamPresentationDto examPresentationDto) throws Exception{
        if (examPresentationDto == null) {
            throw new Exception("Parámetro no válido");
        }
    }*/
}
