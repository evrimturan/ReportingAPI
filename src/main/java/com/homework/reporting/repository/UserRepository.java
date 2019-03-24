package com.homework.reporting.repository;

import com.homework.reporting.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(@Param("username") String username); // SELECT * FROM user WHERE username = %s LIMIT 1;

    List<User> findAllByUsername(@Param("username") String username); // SELECT * FROM user WHERE username = %s;
}
