package com.educlaas.xyzcar.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.educlaas.xyzcar.entity.LikeEntity;

public interface LikeRepository extends JpaRepository<LikeEntity, Long> {
    // You can add custom query methods here if needed
}