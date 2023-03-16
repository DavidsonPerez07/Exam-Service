package com.davidsonperez.evalservice.evaluationservice.data.entity;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class QuestionMultiAnswer extends Question{
    private List<Character> correctAnswers;
}
