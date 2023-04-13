package com.davidsonperez.evalservice.evaluationservice.data.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
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
    @JoinColumn(name = "Student_id_student")
    private Student student;
    @Column(nullable = false)
    private Exam exam;
    @Column(nullable = false)
    @OneToMany
    private List<Answer> answers;
}
