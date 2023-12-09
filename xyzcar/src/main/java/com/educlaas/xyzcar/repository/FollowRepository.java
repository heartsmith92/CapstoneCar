package com.educlaas.xyzcar.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

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
	
	@Query("SELECT p FROM Follow p WHERE p.user.id = :userId AND p.friendID = :friendId AND p.status = 1")
	Optional <Follow> findExistUserAndFollowed(@Param("userId") Long userId, @Param("friendId") Long friendId);
}