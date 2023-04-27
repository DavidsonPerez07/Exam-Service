package com.davidsonperez.evalservice.evaluationservice.web.mapper;

import java.util.List;

import org.mapstruct.factory.Mappers;

import com.davidsonperez.evalservice.evaluationservice.data.entity.Question;
import com.davidsonperez.evalservice.evaluationservice.web.dto.QuestionDto;

public interface QuestionMapper {
    QuestionMapper INSTANCE = Mappers.getMapper(QuestionMapper.class);

    Question questionDtoToQuestion(QuestionDto questionDto);
    
    QuestionDto questionToQuestionDto(Question question);

    List<Question> questionDtosToQuestions(List<QuestionDto> questionDtos);

    List<QuestionDto> questionsToQuestionDtos(List<Question> questions);
}
