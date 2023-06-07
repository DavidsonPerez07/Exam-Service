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
public class AnswerDto implements Serializable {
    private Long idAnswer;
    private String openAnswer;
    private Double assessment;
<<<<<<< HEAD
    private List<Long> optionIds;
=======
    private List<OptionDto> options;
    private QuestionDto question;
    private ExamPresentationDto presentation;
>>>>>>> 94d946e40a3448eadd9de50de2fec81ce4757f89
}
