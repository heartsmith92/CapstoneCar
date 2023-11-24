package com.educlaas.xyzcar.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.educlaas.xyzcar.entity.Post;

public interface PostRepository extends JpaRepository<Post, Long> {
    // You can add custom query methods here if needed
	
    @Query("SELECT p FROM Post p WHERE p.status = :status")
    List<Post> findByStatus(@Param("status") int status);
	
}