package com.educlaas.xyzcar.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.educlaas.xyzcar.entity.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    // You can add custom query methods here if needed
}