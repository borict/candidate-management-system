package com.borict.candidatemanagement.dtos;

import lombok.*;

import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CandidateResponseDto {

    private Long id;
    private String fullName;
    private LocalDate dateOfBirth;
    private String contactNumber;
    private String email;
    private Set<SkillResponseDto> skills;

}
