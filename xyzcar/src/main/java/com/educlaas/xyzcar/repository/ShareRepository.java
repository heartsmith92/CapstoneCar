package com.educlaas.xyzcar.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.educlaas.xyzcar.entity.Share;

public interface ShareRepository extends JpaRepository<Share, Long> {
    // You can add custom query methods here if needed
}