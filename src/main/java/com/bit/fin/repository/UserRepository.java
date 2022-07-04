package com.bit.fin.repository;

import com.bit.fin.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
                                //extends CrudRepository<User, String>

    //Optional<User> findByEmail(String email);

    //Boolean existsByEmail(String email);

}
