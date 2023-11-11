package com.educlaas.xyzcar.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.educlaas.xyzcar.entity.Follow;

public interface FollowRepository extends JpaRepository<Follow, Long> {
    // You can add custom query methods here if needed
}