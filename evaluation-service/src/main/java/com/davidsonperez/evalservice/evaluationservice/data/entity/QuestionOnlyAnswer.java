package com.davidsonperez.evalservice.evaluationservice.data.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class QuestionOnlyAnswer extends Question{
    private Character correctAnswer;
}
