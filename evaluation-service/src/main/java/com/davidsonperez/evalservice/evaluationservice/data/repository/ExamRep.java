package com.davidsonperez.evalservice.evaluationservice.data.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.davidsonperez.evalservice.evaluationservice.data.entity.Exam;

@Repository
public interface ExamRep extends CrudRepository<Exam, Long> {
    
}
