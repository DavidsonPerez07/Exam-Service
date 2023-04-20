package com.davidsonperez.evalservice.evaluationservice.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.davidsonperez.evalservice.evaluationservice.data.entity.Student;
import com.davidsonperez.evalservice.evaluationservice.data.repository.StudentRepository;
import com.davidsonperez.evalservice.evaluationservice.web.dto.StudentDto;
import com.davidsonperez.evalservice.evaluationservice.web.mapper.StudentMapper;

@Service
public class StudentService {
    private StudentRepository studentRepository;
    private Student student;
    private StudentDto studentDto;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public StudentDto saveStudent(StudentDto studentDto) throws Exception {
        if (studentDto == null) {
            throw new Exception("Parámetro no válido");
        }
        else if (studentDto.getIdCard() == null || studentDto.getIdCard().isEmpty()) {
            throw new Exception("Hace falta la identificación del estudiante");
        }
        else if (studentDto.getName() == null || studentDto.getName().isEmpty()) {
            throw new Exception("Hace falta el nombre del estudiante");
        }
        else if (studentDto.getEmail() == null || studentDto.getEmail().isEmpty()) {
            throw new Exception("Hace falta el correo del estudiante");
        }
        
        Student eStudent = StudentMapper.INSTANCE.studentDtoToStudent(studentDto);
        eStudent = studentRepository.save(eStudent);
        return StudentMapper.INSTANCE.studentToStudentDto(eStudent);
    }

    public StudentDto findOne(Long id) {
        student = new Student();
        studentDto = new StudentDto();
        student = studentRepository.findStudentById(id);

        return studentDto = StudentMapper.INSTANCE.studentToStudentDto(student);
    }
}
