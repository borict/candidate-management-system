package com.borict.candidatemanagement.controllers;

import com.borict.candidatemanagement.dtos.CandidateRequestDto;
import com.borict.candidatemanagement.dtos.CandidateResponseDto;
import com.borict.candidatemanagement.dtos.CandidateUpdateDto;
import com.borict.candidatemanagement.services.CandidateService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/candidates")
@RequiredArgsConstructor
public class CandidateController {
    private final CandidateService candidateService;
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CandidateResponseDto create(@Valid @RequestBody CandidateRequestDto dto){
        return candidateService.create(dto);
    }
    @GetMapping
    public List<CandidateResponseDto> findAll(){
        return candidateService.findAll();
    }
    @GetMapping("/{id}")
    public CandidateResponseDto findById(@PathVariable Long id){
        return candidateService.findById(id);
    }
    @PatchMapping("/{id}")
    public CandidateResponseDto update(@PathVariable Long id, @Valid @RequestBody CandidateUpdateDto dto){
        return  candidateService.update(id, dto);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        candidateService.delete(id);
    }
}
