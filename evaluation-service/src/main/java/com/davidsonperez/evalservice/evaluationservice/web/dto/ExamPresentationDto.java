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
    private Long idExamPresentation;
    private Double score;
<<<<<<< HEAD
    private Long studentId;
    private Long examId;
    private List<AnswerDto> answers; 
=======
    private StudentDto student;
    private ExamDto exam;
    private List<AnswerDto> answers;
>>>>>>> 94d946e40a3448eadd9de50de2fec81ce4757f89
}
