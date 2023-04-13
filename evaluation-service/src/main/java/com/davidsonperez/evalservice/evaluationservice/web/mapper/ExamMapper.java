package com.davidsonperez.evalservice.evaluationservice.web.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.davidsonperez.evalservice.evaluationservice.data.entity.Exam;
import com.davidsonperez.evalservice.evaluationservice.web.dto.ExamDto;

@Mapper
public interface ExamMapper {
    ExamMapper INSTANCE = Mappers.getMapper(ExamMapper.class);

    @Mapping(source = "questions", target = "question")
    Exam examDtoToExam(ExamDto examDto);
    
    @Mapping(source = "question", target = "questions")
    ExamDto examToExamDto(Exam exam);
}
