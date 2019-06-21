package com.example.diaryspring.user;

import org.hibernate.validator.constraints.ParameterScriptAssert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    @Query("SELECT u from User u WHERE u.username = :username AND u.userpassword = :password")
    User findByusernameAnduserpassword(@Param("username") String username, @Param("password") String userpassword);

    User findByUsername(String username);
}
