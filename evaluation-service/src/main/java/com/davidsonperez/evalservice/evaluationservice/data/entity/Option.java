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
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "Option")
public class Option implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long optionId;
    @Column(nullable = false)
    private String description;
    private Boolean isCorrect;
    @Column(nullable = false)
    private Question question;
<<<<<<< HEAD
    @OneToMany
    private List<Answer> answers;
=======
    @ManyToOne
    private Answer answer;
<<<<<<< HEAD
>>>>>>> e160c4a (.)
=======
>>>>>>> e160c4ad74e8f5985b4280034fd882a9361843a2
}
