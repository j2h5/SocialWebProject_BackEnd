package com.bit.fin.repository;

import com.bit.fin.entity.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    //JPA Repository를 상속받을 시 findall이나 save와 같은 메서드들을 사용할 수 잇음

    @EntityGraph(attributePaths = "authorities") //해당 쿼리가 수행 될때 Lazy조회가 아니고 Eager조회로 권한정보를 같이 가져오게 됨
    Optional<User> findOneWithAuthoritiesByUsername(String username); //username을 기준으로 user정보를 가져올 때 권한정보도 같이 가져옴
}
