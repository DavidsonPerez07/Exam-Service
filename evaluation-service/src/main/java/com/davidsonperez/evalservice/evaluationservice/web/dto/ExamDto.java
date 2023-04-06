package com.davidsonperez.evalservice.evaluationservice.web.dto;

import java.util.List;

import com.davidsonperez.evalservice.evaluationservice.data.entity.Question;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class ExamDto {
    private Long examId;
    private String introduction;
    private Double maxScore;
    private String examLink;
    private List<Question> questions;

}
