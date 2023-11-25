package com.educlaas.xyzcar.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.educlaas.xyzcar.entity.LikeEntity;
import com.educlaas.xyzcar.entity.Post;
import com.educlaas.xyzcar.entity.User;

@Repository
public interface LikeRepository extends JpaRepository<LikeEntity, Long> {
	
LikeEntity save(LikeEntity like);
	
	// Define a method to find a LikeEntity by User and Post
	LikeEntity findByUserAndPost(User user, Post post);
	@Query("SELECT le.post FROM LikeEntity le WHERE le.user.id = :id")
    List<Post> findAllLikedPostsByUserId(@Param("id") Long id);
	
}