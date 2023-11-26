package com.educlaas.xyzcar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.educlaas.xyzcar.entity.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    // You can add custom query methods here if needed
	
	@Query(value = "SELECT COUNT(c.commentID) FROM Comment c INNER JOIN Post p ON c.fk_postid = p.postID WHERE p.postID = :postId AND c.status = :status", nativeQuery = true)
	long countCommentsByPostIdAndStatus(@Param("postId") Long postId, @Param("status") Integer status);

}