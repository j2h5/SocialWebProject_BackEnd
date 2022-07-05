package com.bit.fin.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Table(name = "users", uniqueConstraints = {
        @UniqueConstraint(columnNames = "email")
})
public class UserEntity {

    @Id
    private String u_id; // 유저에게 고유하게 부여되는 id

    //@JsonIgnore
    @Column(nullable = false)
    private String password;// 패스워드. null이 가능한 이유는 oAuth로 소셜 로그인 할 수 있게

    @Column(nullable = false)
    private String username; // 유저의 이름

    @Email
    @Column(nullable = false)
    private String email; // 유저의 email, 아이디와 같은 기능

    @NotNull
    @Enumerated(EnumType.STRING)
    private Role role;
}
