package com.davidsonperez.evalservice.evaluationservice.web.dto;

import java.io.Serializable;
import java.util.List;

import com.davidsonperez.evalservice.evaluationservice.data.entity.QuestionType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class QuestionDto implements Serializable {
    private Long questionId;
    private String description;
    private Double assessment;
    private QuestionType questionType;
    private String openAnswer;
    private ExamDto exam;
    private List<OptionDto> options;
}
