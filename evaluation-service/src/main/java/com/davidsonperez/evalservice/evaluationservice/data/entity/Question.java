package com.davidsonperez.evalservice.evaluationservice.data.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
@Table(name = "Question")
public class Question implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long questionId;
    @Column(nullable = false)
    private String description;
    @Column(nullable = false)
    private Double assessment;
    @Column(nullable = false)
    private QuestionType questionType;
    private String openAnswer;
    @Column(nullable = false)
    @ManyToOne
    private Exam exam;
    @OneToMany
    private Option option;
}
