package com.borict.candidatemanagement.dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SkillRequestDto {

    @NotBlank(message = "Skill name is required")
    private String name;

}
