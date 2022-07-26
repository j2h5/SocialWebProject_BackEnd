package com.bit.fin.dto;

import com.bit.fin.entity.User;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.apache.ibatis.type.Alias;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;
import java.util.stream.Collectors;

@Alias("user")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    @Size(min = 1, max = 200)
    private int user_id;

    @Size(min = 1, max = 200)
    private String username;

    @Size(min = 1, max = 200)
    private String realname;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Size(min = 1, max = 200)
    private String password;

    @NotNull
    @Size(min = 1, max = 200)
    private String email;

    @Size(min = 1, max = 200)
    private String profile;

    private Set<AuthorityDto> authorityDtoSet;

    public static UserDto from(User user) {
        if(user == null) return null;

        return UserDto.builder()
                .username(user.getUsername())
                .realname(user.getRealname())
                .email(user.getEmail())
                .profile(user.getProfile())
                .authorityDtoSet(user.getAuthorities().stream()
                        .map(authority -> AuthorityDto.builder().authorityName(authority.getAuthorityName()).build())
                        .collect(Collectors.toSet()))
                .build();
    }
}