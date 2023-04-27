package com.davidsonperez.evalservice.evaluationservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.davidsonperez.evalservice.evaluationservice.data.entity.Exam;
import com.davidsonperez.evalservice.evaluationservice.data.entity.Option;
import com.davidsonperez.evalservice.evaluationservice.data.entity.Question;
import com.davidsonperez.evalservice.evaluationservice.data.repository.ExamRepository;
import com.davidsonperez.evalservice.evaluationservice.data.repository.OptionRepository;
import com.davidsonperez.evalservice.evaluationservice.data.repository.QuestionRepository;
import com.davidsonperez.evalservice.evaluationservice.web.dto.ExamDto;
import com.davidsonperez.evalservice.evaluationservice.web.dto.OptionDto;
import com.davidsonperez.evalservice.evaluationservice.web.dto.QuestionDto;
import com.davidsonperez.evalservice.evaluationservice.web.mapper.ExamMapper;
import com.davidsonperez.evalservice.evaluationservice.web.mapper.OptionMapper;
import com.davidsonperez.evalservice.evaluationservice.web.mapper.QuestionMapper;

@Service
public class ExamService {
    private ExamRepository examRepository;
    private OptionRepository optionRepository;
    private QuestionRepository questionRepository;

    public ExamService(ExamRepository examRepository, OptionRepository optionRepository, 
    QuestionRepository questionRepository) {
        this.examRepository = examRepository;
        this.optionRepository = optionRepository;
        this.questionRepository = questionRepository;
    }

    public ExamDto saveExam(ExamDto examDto) throws Exception {
        if (examDto == null) {
            throw new Exception("Parámetro no válido");
        }

        Exam eExam = ExamMapper.INSTANCE.examDtoToExam(examDto);
        eExam = examRepository.save(eExam);
        return ExamMapper.INSTANCE.examToExamDto(eExam);
    }

    public ExamDto getExam(Long idExam) {
        Optional<Exam> exam;
        exam = examRepository.findById(idExam);

        ExamDto examDto = new ExamDto();

        if (exam.isPresent()) {
            examDto = ExamMapper.INSTANCE.examToExamDto(exam.get());
        }
        else {
            examDto = null;
        }

        return examDto;
    }

    public QuestionDto saveQuestion(QuestionDto questionDto) throws Exception {
        if (questionDto == null) {
            throw new Exception("Parámetro no válido");
        }

        Optional<Exam> exam = examRepository.findById(1L);
        ExamDto examDto = new ExamDto();

        if (exam.isPresent()) {
            examDto = ExamMapper.INSTANCE.examToExamDto(exam.get());
        }
        else {
            examDto = null;
        }

        questionDto.setExam(examDto);

        Question eQuestion = QuestionMapper.INSTANCE.questionDtoToQuestion(questionDto);
        questionRepository.save(eQuestion);
        return QuestionMapper.INSTANCE.questionToQuestionDto(eQuestion);
    }

    public OptionDto saveOption(OptionDto optionDto, Long idQuestion) throws Exception {
        if (optionDto == null) {
            throw new Exception("Parámetro no válido");
        }
        
        Optional<Question> question = questionRepository.findById(idQuestion);
        Question eQuestion = new Question();

        if (question.isPresent()) {
            eQuestion.setIdQuestion(question.get().getIdQuestion());
            eQuestion.setDescription(question.get().getDescription());
            eQuestion.setAssessment(question.get().getAssessment());
            eQuestion.setQuestionType(question.get().getQuestionType());
            eQuestion.setOpenAnswer(question.get().getOpenAnswer());
            eQuestion.setExam(question.get().getExam());
            eQuestion.setOptions(question.get().getOptions());
        }
        else {
            eQuestion = null;
        }

        Option eOption = OptionMapper.INSTANCE.optionDtoToOption(optionDto);
        eOption.setQuestion(eQuestion);
        eOption = optionRepository.save(eOption);
        return OptionMapper.INSTANCE.optionToOptionDto(eOption);
    }
}
