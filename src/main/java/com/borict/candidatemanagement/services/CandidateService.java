package com.borict.candidatemanagement.services;

import com.borict.candidatemanagement.dtos.CandidateRequestDto;
import com.borict.candidatemanagement.dtos.CandidateResponseDto;
import com.borict.candidatemanagement.dtos.CandidateUpdateDto;

import java.util.List;

public interface CandidateService {
    CandidateResponseDto create(CandidateRequestDto dto);
    List<CandidateResponseDto> findAll();
    CandidateResponseDto findById(Long id);
    CandidateResponseDto update(Long id, CandidateUpdateDto dto);
    void delete(Long id);
}
