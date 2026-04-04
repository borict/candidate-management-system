package com.borict.candidatemanagement.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CandidateResponseDto {
    private Long id;
    private String fullName;
    private LocalDate dateOfBirth;
    private String contactNumber;
    private String email;
    private Set<SkillRequestDto> skills;
}
