package com.davidsonperez.evalservice.evaluationservice.data.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "Exam")
public class Exam implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long examId;
    @Column(nullable = false)
    private String introduction;
    @Column(nullable = false)
    private Double maxScore;
    @Column(nullable = false)
    private String examLink;
    @Column(nullable = false)
    @OneToMany
    private Question question;
}
