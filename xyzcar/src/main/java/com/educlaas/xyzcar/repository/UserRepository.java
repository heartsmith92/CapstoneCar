package com.educlaas.xyzcar.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.educlaas.xyzcar.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);

	static List<User> findByUsernameContainingIgnoreCase(String query) {
		// TODO Auto-generated method stub
		return null;
	}

    User findByEmail(String email);

}

