package com.davidsonperez.evalservice.evaluationservice.web.dto;

import com.davidsonperez.evalservice.evaluationservice.data.entity.Exam;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentDto {
    private Long id;
    private String idCard;
    private String name;
    private String email;
    private Float qualification;
    private Exam exam;
    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getIdCard() {
        return idCard;
    }
    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public Float getQualification() {
        return qualification;
    }
    public void setQualification(Float qualification) {
        this.qualification = qualification;
    }
    public Exam getExam() {
        return exam;
    }
    public void setExam(Exam exam) {
        this.exam = exam;
    }
}
