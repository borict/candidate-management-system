package com.borict.candidatemanagement.services;
import com.borict.candidatemanagement.dtos.CandidateRequestDto;
import com.borict.candidatemanagement.dtos.CandidateResponseDto;
import com.borict.candidatemanagement.dtos.CandidateUpdateDto;
import com.borict.candidatemanagement.exceptions.ResourceNotFoundException;
import com.borict.candidatemanagement.mappers.CandidateMapper;
import com.borict.candidatemanagement.models.Candidate;
import com.borict.candidatemanagement.repositories.CandidateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CandidateServiceImpl implements  CandidateService{
    private final CandidateRepository candidateRepository;
    @Override
    public CandidateResponseDto create(CandidateRequestDto dto) {
        Candidate candidate = CandidateMapper.toEntity(dto);
        return CandidateMapper.toResponseDto(
                candidateRepository.save(candidate)
        );
    }
    @Override
    public List<CandidateResponseDto> findAll() {
        return candidateRepository.findAll()
                .stream()
                .map(CandidateMapper::toResponseDto)
                .toList();
    }
    @Override
    public CandidateResponseDto findById(Long id) {
        Candidate candidate = candidateRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Candidate not found with id: " + id));
        return CandidateMapper.toResponseDto(candidate);
    }
    @Override
    public CandidateResponseDto update(Long id, CandidateUpdateDto dto) {
        Candidate candidate = candidateRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Candidate not found with id: " + id));
        CandidateMapper.updateEntity(candidate, dto);
        return CandidateMapper.toResponseDto(
                candidateRepository.save(candidate)
        );
    }
    @Override
    public void delete(Long id) {
        Candidate candidate = candidateRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Candidate not found with id: " + id));
        candidateRepository.delete(candidate);
    }
}
