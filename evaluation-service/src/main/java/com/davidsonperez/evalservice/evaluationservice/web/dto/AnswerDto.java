package com.davidsonperez.evalservice.evaluationservice.web.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class AnswerDto implements Serializable {
    private Long answerId;
    private String openAnswer;
    private Double asessment;
    private OptionDto option;
    private QuestionDto question;
}
