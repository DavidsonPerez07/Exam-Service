package com.davidsonperez.evalservice.evaluationservice.web.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.davidsonperez.evalservice.evaluationservice.data.entity.Answer;
import com.davidsonperez.evalservice.evaluationservice.web.dto.AnswerDto;

@Mapper
public interface AnswerMapper {
    AnswerMapper INSTANCE = Mappers.getMapper(AnswerMapper.class);

    Answer answerDtoToAnswer(AnswerDto answerDto);
    
    AnswerDto answerToAnswerDto(Answer answer);
}
