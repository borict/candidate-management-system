package com.borict.candidatemanagement.dtos;

import jakarta.validation.constraints.Email;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CandidateUpdateDto {

    private String fullName;
    private LocalDate dateOfBirth;
    private String contactNumber;
    @Email(message = "Email must be valid")
    private String email;

}
