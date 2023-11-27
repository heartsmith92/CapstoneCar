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
    // You can add custom query methods here if needed
	
	@Query(value = "SELECT COUNT(l.likeID) FROM Like_Entity l INNER JOIN Post p ON l.fk_postid = p.postID WHERE p.postID = :postId AND l.status = :status", nativeQuery = true)
	long countLikesByPostIdAndStatus(@Param("postId") Long postId, @Param("status") Integer status);


	
	
LikeEntity save(LikeEntity like);
	
	// Define a method to find a LikeEntity by User and Post
	LikeEntity findByUserAndPost(User user, Post post);
	@Query("SELECT le.post FROM LikeEntity le WHERE le.user.id = :userId AND le.status = :status")
	List<Post> findAllLikedPostsByUserIdAndStatus(@Param("userId") Long userId, @Param("status") Integer status);
	@Query("SELECT le.post FROM LikeEntity le WHERE le.user.id = :userId AND le.status = :status")
	List<Post> findAllDisLikedPostsByUserIdAndStatus(@Param("userId") Long userId, @Param("status") Integer status);
}