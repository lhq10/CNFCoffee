package edu.mum.dtos.userDtos;


import edu.mum.dtos.subProgramDtos.SubProgramDto;
import edu.mum.models.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetMeDto {
    private Long userId;
    private String email;
    private String displayName;
//    @Temporal(TemporalType.DATE)
//    @DateTimeFormat(pattern = "yyyy/MM/dd")
//    private Date bod;
    private String phoneNumber;
    private User avatarUrl;
    private String status;
    private String role;
    private Date updatedAt;
    @Nullable
    private List<DonateByUserDto> donations;
    @Nullable
    private List<SubProgramDto> subPrograms;
    @Nullable
    private Long partnerId;
}
