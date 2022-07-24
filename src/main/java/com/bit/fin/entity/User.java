package com.bit.fin.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Entity //Database 테이블과 1:1 매핑되는 객체를 뜻함
@Table(name = "user") // Table 명을 User로 지정
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@DynamicInsert
public class User {

    @Id // Primary Key
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Auto_Increment
    private Long userId;

    @Column(name = "username", length = 200, unique = true)
    private String username;

    @Column(name = "realname", length = 200)
    private String realname;

    @Column(name = "email", length = 200, unique = true)
    private String email;

    @Column(name = "password", length = 200)
    private String password;

    @Column(name = "profile",length = 200)
    @ColumnDefault("N")
    private String profile;

    @Column(name = "activated")
    private boolean activated; //활성화 여부

    @PrePersist
    public void prePersist() {
        this.profile = this.profile == null ? "profile.jpg" : this.profile;
    }

    // User객체와 권한 객체의 다대다 관계를 중간에 연결 조인테이블로 정의
    @ManyToMany
    @JoinTable(
            name = "user_authority",
            joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "authority_name", referencedColumnName = "authority_name")})
    private Set<Authority> authorities; // 권한들에 대한 관계
}