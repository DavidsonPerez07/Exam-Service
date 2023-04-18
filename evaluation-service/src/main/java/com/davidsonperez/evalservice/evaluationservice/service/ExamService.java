package com.davidsonperez.evalservice.evaluationservice.service;

import java.util.List;

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

    public List<QuestionDto> saveQuestions(List<QuestionDto> questionDtos) throws Exception {
        List<Question> questions = QuestionMapper.INSTANCE.questionDtosToQuestions(questionDtos);

        for (int i = 0; i < questions.size(); i++) {
            if (questions.get(i) == null) {
                throw new Exception("Parámetro no válido");
            }

            questionRepository.save(questions.get(i));
        }
        
        return QuestionMapper.INSTANCE.questionsToQuestionDtos(questions);
    }

    public List<OptionDto> saveOptions(List<OptionDto> optionDtos) throws Exception {
        List<Option> options = OptionMapper.INSTANCE.optionDtosToOptions(optionDtos);

        for (int i = 0; i < options.size(); i++) {
            if (options.get(i) == null) {
                throw new Exception("Parámetro no válido");
            }

            optionRepository.save(options.get(i));
        }

        return OptionMapper.INSTANCE.optionsToOptionDtos(options);
    }

    public OptionDto saveOption(OptionDto optionDto) throws Exception {
        if (optionDto == null) {
            throw new Exception("Parámetro no válido");
        }
        
        Option eOption = OptionMapper.INSTANCE.optionDtoToOption(optionDto);
        eOption = optionRepository.save(eOption);
        return OptionMapper.INSTANCE.optionToOptionDto(eOption);
    }
}
