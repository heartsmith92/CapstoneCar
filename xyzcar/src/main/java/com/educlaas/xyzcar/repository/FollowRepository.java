package com.educlaas.xyzcar.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.educlaas.xyzcar.entity.Follow;

public interface FollowRepository extends JpaRepository<Follow, Long> {

	List<Follow> findByUserId(Long userId);
    // You can add custom query methods here if needed

	List<Follow> findByUserIdAndStatus(Long userId, int status);
}