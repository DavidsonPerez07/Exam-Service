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

import org.hibernate.annotations.ManyToAny;

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
public class ExamPresentation implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long examPresentationId;
    @Column(nullable = false)
    private Double score;
    @Column(nullable = false)
    @ManyToOne
    private Student student;
    @Column(nullable = false)
    private Exam exam;
    @Column(nullable = false)
    @OneToMany
    private Answer answer;
}
