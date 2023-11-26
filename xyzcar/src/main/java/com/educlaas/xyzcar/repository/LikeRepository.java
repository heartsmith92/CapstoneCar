package com.educlaas.xyzcar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.educlaas.xyzcar.entity.LikeEntity;

public interface LikeRepository extends JpaRepository<LikeEntity, Long> {
    // You can add custom query methods here if needed
	
	@Query(value = "SELECT COUNT(l.likeID) FROM Like_Entity l INNER JOIN Post p ON l.fk_postid = p.postID WHERE p.postID = :postId AND l.status = :status", nativeQuery = true)
	long countLikesByPostIdAndStatus(@Param("postId") Long postId, @Param("status") Integer status);


	
}