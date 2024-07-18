package edu.mum.dtos.subProgramDtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateSubProgramDto {
    private Long programId;
    private String type;

}
