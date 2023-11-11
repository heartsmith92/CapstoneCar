package com.educlaas.xyzcar.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.educlaas.xyzcar.entity.Community;

public interface CommunityRepository extends JpaRepository<Community, Long> {
    // You can add custom query methods here if needed
}