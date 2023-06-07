package com.davidsonperez.evalservice.evaluationservice.web.mapper;

<<<<<<< HEAD
import java.util.List;

=======
>>>>>>> 94d946e40a3448eadd9de50de2fec81ce4757f89
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.davidsonperez.evalservice.evaluationservice.data.entity.ExamPresentation;
import com.davidsonperez.evalservice.evaluationservice.web.dto.ExamPresentationDto;

@Mapper
public interface ExamPresentationMapper {
    ExamPresentationMapper INSTANCE = Mappers.getMapper(ExamPresentationMapper.class);

    ExamPresentation examPresentationDtoToExamPresentation(ExamPresentationDto examPresentationDto);

    ExamPresentationDto examPresentationToExamPresentationDto(ExamPresentation examPresentation);
    
<<<<<<< HEAD
    List<ExamPresentationDto> presentationsTopresentationDtos(List<ExamPresentation> examPresentations);
=======
>>>>>>> 94d946e40a3448eadd9de50de2fec81ce4757f89
}
