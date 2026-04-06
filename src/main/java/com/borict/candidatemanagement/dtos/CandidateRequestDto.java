package com.borict.candidatemanagement.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CandidateRequestDto {

    @NotBlank(message = "Full name is required")
    private String fullName;

    @NotNull(message = "Date of birth is required")
    private LocalDate dateOfBirth;

    @NotBlank(message = "Contact number is required")
    private String contactNumber;

    @NotBlank(message = "Email is required")
    @Email(message = "Email must be valid")
    private String email;

}
