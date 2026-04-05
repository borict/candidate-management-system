package com.borict.candidatemanagement.controllers;

import com.borict.candidatemanagement.dtos.CandidateRequestDto;
import com.borict.candidatemanagement.dtos.CandidateResponseDto;
import com.borict.candidatemanagement.dtos.CandidateUpdateDto;
import com.borict.candidatemanagement.dtos.SkillRequestDto;
import com.borict.candidatemanagement.services.CandidateService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@Tag(name = "Candidate Controller", description = "Endpoints for managing candidates and their skills")
@RestController
@RequestMapping("/api/candidates")
@RequiredArgsConstructor
public class CandidateController {
    private final CandidateService candidateService;
    @Operation(summary = "Create candidate", description = "Creates a new candidate")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CandidateResponseDto create(@Valid @RequestBody CandidateRequestDto dto){
        return candidateService.create(dto);
    }
    @Operation(summary = "Get all candidates", description = "Returns a list of all candidates")
    @GetMapping
    public List<CandidateResponseDto> findAll(){
        return candidateService.findAll();
    }
    @Operation(summary = "Get candidate by ID", description = "Returns a candidate by their ID")
    @GetMapping("/{id}")
    public CandidateResponseDto findById(@PathVariable Long id){
        return candidateService.findById(id);
    }
    @Operation(summary = "Update candidate", description = "Updates an existing candidate")
    @PatchMapping("/{id}")
    public CandidateResponseDto update(@PathVariable Long id, @Valid @RequestBody CandidateUpdateDto dto){
        return  candidateService.update(id, dto);
    }
    @Operation(summary = "Delete candidate", description = "Deletes a candidate by ID")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        candidateService.delete(id);
    }
    @Operation(summary = "Add skill to candidate", description = "Adds a skill to the selected candidate")
    @PostMapping("/{candidateId}/skills")
    public CandidateResponseDto addSkill(@PathVariable Long candidateId,
                                         @Valid @RequestBody SkillRequestDto dto) {
        return candidateService.addSkill(candidateId, dto);
    }
    @Operation(summary = "Remove skill from candidate", description = "Removes a skill from the selected candidate")
    @DeleteMapping("/{candidateId}/skills/{skillId}")
    @ResponseStatus(HttpStatus.OK)
    public CandidateResponseDto removeSkill(@PathVariable Long candidateId,
                                            @PathVariable Long skillId) {
        return candidateService.removeSkill(candidateId, skillId);
    }
    @Operation(summary = "Search candidates by full name", description = "Return candidates whose full name contains the given text")
    @GetMapping("/search")
    public ResponseEntity<List<CandidateResponseDto>> searchCandidatesByFullName(@RequestParam String fullName){
        return ResponseEntity.ok(candidateService.searchCandidatesByFullName(fullName));
    }
    @Operation(summary = "Search candidates by skill", description = "Returns candidates who have the given skill")
    @GetMapping("/search/by-skill")
    public ResponseEntity<List<CandidateResponseDto>> searchCandidatesBySkill(@RequestParam String skill){
        return ResponseEntity.ok(candidateService.searchCandidatesBySkill(skill));
    }
}
