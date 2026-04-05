package com.borict.candidatemanagement.services;

import com.borict.candidatemanagement.dtos.CandidateRequestDto;
import com.borict.candidatemanagement.dtos.CandidateResponseDto;
import com.borict.candidatemanagement.dtos.CandidateUpdateDto;
import com.borict.candidatemanagement.dtos.SkillRequestDto;

import java.util.List;

public interface CandidateService {
    CandidateResponseDto create(CandidateRequestDto dto);
    List<CandidateResponseDto> findAll();
    CandidateResponseDto findById(Long id);
    CandidateResponseDto update(Long id, CandidateUpdateDto dto);
    void delete(Long id);
    CandidateResponseDto addSkill(Long candidateId, SkillRequestDto dto);
    CandidateResponseDto removeSkill(Long candidateId, Long skillId);
    List<CandidateResponseDto> searchCandidatesByFullName(String fullName);
    List<CandidateResponseDto> searchCandidatesBySkill(String skill);
}
