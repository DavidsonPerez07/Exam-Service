package com.davidsonperez.evalservice.evaluationservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.davidsonperez.evalservice.evaluationservice.data.entity.Student;
import com.davidsonperez.evalservice.evaluationservice.data.repository.StudentRepository;
import com.davidsonperez.evalservice.evaluationservice.web.dto.StudentDto;
import com.davidsonperez.evalservice.evaluationservice.web.mapper.StudentMapper;

@Service
public class StudentService {
    private StudentRepository studentRepository;

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

    public StudentDto getStudent(Long idStudent) {
        Optional<Student> student;
        student = studentRepository.findById(idStudent);

        StudentDto studentDto = new StudentDto();

        if(student.isPresent()) {
            studentDto.setIdStudent(student.get().getIdStudent());
            studentDto.setIdCard(student.get().getIdCard());
            studentDto.setName(student.get().getName());
            studentDto.setEmail(student.get().getEmail());
        }
        else {
            studentDto = null;
        }

        return studentDto;
    }

    public List<StudentDto> getAllStudents() {
        List<Student> students; 
        students = studentRepository.findAll();

        return StudentMapper.INSTANCE.studentsToStudentDtos(students);
    }

    public boolean deleteStudent(Long idStudent) {
        Boolean exists = studentRepository.existsById(idStudent);

        if (exists) {
            studentRepository.deleteById(idStudent);
        }
        else {
            return false;
        }

        return exists;
    }
}
