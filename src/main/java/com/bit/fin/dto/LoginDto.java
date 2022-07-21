package com.bit.fin.dto;

import lombok.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LoginDto {

    @NotNull
    @Size(min = 3, max = 100)  //@Valid 관련
    private String username;

    @NotNull
    @Size(min = 3, max = 100)
    private String password;
}
