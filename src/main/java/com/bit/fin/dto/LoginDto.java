package com.bit.fin.dto;

import lombok.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LoginDto {

    //@NotNull
    //@Size(min = 3, max = 50)  //@Valid 관련
    private String u_id; //이후 valid 여기에 적용???

    //@NotNull
    //@Size(min = 3, max = 100)
    private String u_password;
}
