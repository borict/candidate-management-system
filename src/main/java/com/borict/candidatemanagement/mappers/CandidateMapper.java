package com.borict.candidatemanagement.mappers;

import com.borict.candidatemanagement.dtos.CandidateRequestDto;
import com.borict.candidatemanagement.dtos.CandidateResponseDto;
import com.borict.candidatemanagement.dtos.CandidateUpdateDto;
import com.borict.candidatemanagement.dtos.SkillResponseDto;
import com.borict.candidatemanagement.models.Candidate;
import com.borict.candidatemanagement.models.Skill;
import java.util.Set;
import java.util.stream.Collectors;

public class CandidateMapper {

    public static Candidate toEntity(CandidateRequestDto dto){
        return Candidate.builder()
                .fullName(dto.getFullName())
                .dateOfBirth(dto.getDateOfBirth())
                .contactNumber(dto.getContactNumber())
                .email(dto.getEmail())
                .build();
    }

    public static CandidateResponseDto toResponseDto(Candidate candidate){
        return CandidateResponseDto.builder()
                .id(candidate.getId())
                .fullName(candidate.getFullName())
                .dateOfBirth(candidate.getDateOfBirth())
                .contactNumber(candidate.getContactNumber())
                .email(candidate.getEmail())
                .skills(mapSkills(candidate.getSkills()))
                .build();
    }

    public static SkillResponseDto toSkillResponseDto(Skill skill){
        return SkillResponseDto.builder()
                .id(skill.getId())
                .name(skill.getName())
                .build();
    }

    public static void updateEntity(Candidate candidate, CandidateUpdateDto dto){
        if(dto.getFullName() != null)
            candidate.setFullName(dto.getFullName());
        if(dto.getDateOfBirth() != null)
            candidate.setDateOfBirth(dto.getDateOfBirth());
        if(dto.getContactNumber() != null)
            candidate.setContactNumber(dto.getContactNumber());
        if(dto.getEmail() != null)
            candidate.setEmail(dto.getEmail());
    }

    private static Set<SkillResponseDto> mapSkills(Set<Skill> skills){
        return skills.stream()
                .map(CandidateMapper::toSkillResponseDto)
                .collect(Collectors.toSet());
    }
}
