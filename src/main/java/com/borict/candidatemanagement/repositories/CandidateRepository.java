package com.borict.candidatemanagement.repositories;

import com.borict.candidatemanagement.models.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CandidateRepository extends JpaRepository<Candidate, Long> {
    List<Candidate> findByFullNameContainingIgnoreCase(String name);
}
