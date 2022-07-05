package com.bit.fin.repository;

import com.bit.fin.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, String> {
                                //extends CrudRepository<User, String>

    //Optional<User> findByEmail(String email);

    //Boolean existsByEmail(String email);

}
