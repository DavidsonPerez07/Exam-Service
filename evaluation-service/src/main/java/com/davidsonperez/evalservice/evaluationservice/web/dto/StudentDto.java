package com.davidsonperez.evalservice.evaluationservice.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class StudentDto {
    private Long id;
    private String idCard;
    private String name;
    private String email;
}
