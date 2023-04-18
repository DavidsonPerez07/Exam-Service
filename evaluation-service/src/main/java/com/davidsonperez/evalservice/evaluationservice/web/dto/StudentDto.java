package com.davidsonperez.evalservice.evaluationservice.web.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentDto implements Serializable {
    private Long id_student;
    private String idCard;
    private String name;
    private String email;
    
    public Long getIdStudent() {
        return id_student;
    }
    public void setIdStudent(Long id_student) {
        this.id_student = id_student;
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
}
