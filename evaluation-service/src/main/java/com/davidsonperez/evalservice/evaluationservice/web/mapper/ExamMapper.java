package com.davidsonperez.evalservice.evaluationservice.web.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.davidsonperez.evalservice.evaluationservice.data.entity.Exam;
import com.davidsonperez.evalservice.evaluationservice.web.dto.ExamDto;

@Mapper
public interface ExamMapper {
    ExamMapper INSTANCE = Mappers.getMapper(ExamMapper.class);

    Exam examDtoToExam(ExamDto examDto);
    
    ExamDto examToExamDto(Exam exam);
    
}
