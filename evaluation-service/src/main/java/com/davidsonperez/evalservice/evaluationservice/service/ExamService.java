package com.davidsonperez.evalservice.evaluationservice.service;

//import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.davidsonperez.evalservice.evaluationservice.data.entity.Exam;
import com.davidsonperez.evalservice.evaluationservice.data.repository.ExamRepository;
import com.davidsonperez.evalservice.evaluationservice.web.dto.ExamDto;
import com.davidsonperez.evalservice.evaluationservice.web.mapper.ExamMapper;

@Service
public class ExamService {
    private ExamRepository examRepository;

    public ExamService(ExamRepository examRepository) {
        this.examRepository = examRepository;
    }

    public ExamDto saveExam(ExamDto examDto) throws Exception {
        if (examDto == null) {
            throw new Exception("Parámetro no válido");
        }
        
        Exam eExam = ExamMapper.INSTANCE.examDtoToExam(examDto);
        eExam = examRepository.save(eExam);
        return ExamMapper.INSTANCE.examToExamDto(eExam);
    }
}
