package com.davidsonperez.evalservice.evaluationservice.web.mapper;

<<<<<<< HEAD
import java.util.List;

=======
>>>>>>> 94d946e40a3448eadd9de50de2fec81ce4757f89
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.davidsonperez.evalservice.evaluationservice.data.entity.Exam;
import com.davidsonperez.evalservice.evaluationservice.web.dto.ExamDto;

@Mapper
public interface ExamMapper {
    ExamMapper INSTANCE = Mappers.getMapper(ExamMapper.class);

    Exam examDtoToExam(ExamDto examDto);
    
    ExamDto examToExamDto(Exam exam);
    
<<<<<<< HEAD
    List<ExamDto> examsToExamDtos(List<Exam> exams);
=======
>>>>>>> 94d946e40a3448eadd9de50de2fec81ce4757f89
}
