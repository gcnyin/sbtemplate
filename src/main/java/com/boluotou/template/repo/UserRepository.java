package com.boluotou.template.repo;

import com.boluotou.template.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, String> {
  @Query("select u from User u where u.username = :username")
  User getUserByUsername(@Param("username") String username);
}
