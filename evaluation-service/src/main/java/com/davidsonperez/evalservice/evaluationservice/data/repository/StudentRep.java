package com.davidsonperez.evalservice.evaluationservice.data.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.davidsonperez.evalservice.evaluationservice.data.entity.Student;

@Repository
public interface StudentRep extends CrudRepository<Student, Long> {
    
}
