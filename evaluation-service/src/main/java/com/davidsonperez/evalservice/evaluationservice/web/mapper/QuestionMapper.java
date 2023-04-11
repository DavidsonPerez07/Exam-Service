package com.davidsonperez.evalservice.evaluationservice.web.mapper;

import org.mapstruct.factory.Mappers;

import com.davidsonperez.evalservice.evaluationservice.data.entity.Question;
import com.davidsonperez.evalservice.evaluationservice.web.dto.QuestionDto;

public interface QuestionMapper {
    QuestionMapper INSTANCE = Mappers.getMapper(QuestionMapper.class);

    Question questioDtoToQuestion(QuestionDto questionDto);
    
    QuestionDto questionToQuestionDto(Question question);
}
