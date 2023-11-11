package com.educlaas.xyzcar.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.educlaas.xyzcar.entity.Post;

public interface PostRepository extends JpaRepository<Post, Long> {
    // You can add custom query methods here if needed
}