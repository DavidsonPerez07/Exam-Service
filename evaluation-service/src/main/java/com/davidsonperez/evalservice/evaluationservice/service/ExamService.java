package com.davidsonperez.evalservice.evaluationservice.service;

<<<<<<< HEAD
import java.util.List;
=======
>>>>>>> 94d946e40a3448eadd9de50de2fec81ce4757f89
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.davidsonperez.evalservice.evaluationservice.data.entity.Exam;
import com.davidsonperez.evalservice.evaluationservice.data.entity.Option;
import com.davidsonperez.evalservice.evaluationservice.data.entity.Question;
import com.davidsonperez.evalservice.evaluationservice.data.repository.ExamRepository;
import com.davidsonperez.evalservice.evaluationservice.data.repository.OptionRepository;
import com.davidsonperez.evalservice.evaluationservice.data.repository.QuestionRepository;
<<<<<<< HEAD
import com.davidsonperez.evalservice.evaluationservice.web.dto.ExamDto; 
=======
import com.davidsonperez.evalservice.evaluationservice.web.dto.ExamDto;
import com.davidsonperez.evalservice.evaluationservice.web.dto.OptionDto;
import com.davidsonperez.evalservice.evaluationservice.web.dto.QuestionDto;
>>>>>>> 94d946e40a3448eadd9de50de2fec81ce4757f89
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

<<<<<<< HEAD
        examDto.setExamLink("http://localhost:4200/exam-presentation/take-exam");

=======
>>>>>>> 94d946e40a3448eadd9de50de2fec81ce4757f89
        final Exam eExam =  examRepository.save(ExamMapper.INSTANCE.examDtoToExam(examDto));

        examDto.getQuestions().forEach(q -> {
            final Question question = QuestionMapper.INSTANCE.questionDtoToQuestion(q);
            question.setExam(eExam);
            questionRepository.save(question);

            if(q.getOptions() != null) {
                q.getOptions().forEach(o -> {
                    Option option = OptionMapper.INSTANCE.optionDtoToOption(o);
                    option.setQuestion(question);
                    optionRepository.save(option);
                });
            }
        });


        return getExam(eExam.getIdExam());
    }

    public ExamDto getExam(Long idExam) {
        Optional<Exam> exam;
        exam = examRepository.findById(idExam);

        ExamDto examDto = null;

        if (exam.isPresent()) {
            examDto = ExamMapper.INSTANCE.examToExamDto(exam.get());
        }

        return examDto;
    }

<<<<<<< HEAD
    public boolean deleteExam(Long idExam) {
        Boolean exists = examRepository.existsById(idExam);

        if (exists) {
            examRepository.deleteById(idExam);
        }
        else {
            return false;
        }

        return exists;
    }

    public List<ExamDto> getAllExams() {
        List<Exam> exams; 
        exams = examRepository.findAll();

        return ExamMapper.INSTANCE.examsToExamDtos(exams);
=======
    public QuestionDto saveQuestion(QuestionDto questionDto) throws Exception {
        if (questionDto == null) {
            throw new Exception("Parámetro no válido");
        }

        Optional<Exam> exam = examRepository.findById(1L);

        Question eQuestion = QuestionMapper.INSTANCE.questionDtoToQuestion(questionDto);
        eQuestion.setExam(exam.orElse(null));
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
>>>>>>> 94d946e40a3448eadd9de50de2fec81ce4757f89
    }
}
