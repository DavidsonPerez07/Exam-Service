package com.davidsonperez.evalservice.evaluationservice.data.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "ExamPresentation")
public class ExamPresentation {
    private Student student;
    private Exam exam;
    private Double score;
}
