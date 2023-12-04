package com.educlaas.xyzcar.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.educlaas.xyzcar.entity.Follow;
import com.educlaas.xyzcar.entity.User;

public interface FollowRepository extends JpaRepository<Follow, Long> {

	List<Follow> findByUserId(Long userId);
    // You can add custom query methods here if needed

	List<Follow> findByUserIdAndStatus(Long userId, int status);

	static List<Follow> findByUserAndFriend(User user, User user2) {
		// TODO Auto-generated method stub
		return null;
	}
}