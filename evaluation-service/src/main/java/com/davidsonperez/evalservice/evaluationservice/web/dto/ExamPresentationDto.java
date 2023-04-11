package com.davidsonperez.evalservice.evaluationservice.web.dto;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class ExamPresentationDto implements Serializable {
    private Long examPresentationId;
    private Double score;
    private StudentDto student;
    private ExamDto exam;
    private List<AnswerDto> answers;
}
