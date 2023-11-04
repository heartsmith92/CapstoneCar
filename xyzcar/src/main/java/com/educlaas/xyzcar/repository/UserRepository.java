package com.educlaas.xyzcar.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.educlaas.xyzcar.dao.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}

