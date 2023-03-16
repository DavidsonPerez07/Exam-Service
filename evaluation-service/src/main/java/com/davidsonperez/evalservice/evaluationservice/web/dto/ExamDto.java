package com.davidsonperez.evalservice.evaluationservice.web.dto;

import java.util.List;

import com.davidsonperez.evalservice.evaluationservice.data.entity.Question;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ExamDto {
    private String description;
    private Float maxQual;
    private Float finalQual;
    private List<Question> questions;

    public void addQuestion(Question question) {
        questions.add(question);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Float getMaxQual() {
        return maxQual;
    }

    public void setMaxQual(Float maxQual) {
        this.maxQual = maxQual;
    }

    public Float getFinalQual() {
        return finalQual;
    }

    public void setFinalQual(Float finalQual) {
        this.finalQual = finalQual;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }
}
