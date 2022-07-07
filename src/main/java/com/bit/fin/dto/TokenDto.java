package com.bit.fin.dto;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
//Token 정보를 Response 할 때 사용
public class TokenDto {

    private String token;
}