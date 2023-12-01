package com.educlaas.xyzcar.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.educlaas.xyzcar.entity.Comment;
import com.educlaas.xyzcar.entity.Post;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    // You can add custom query methods here if needed
	
	@Query(value = "SELECT COUNT(c.commentID) FROM Comment c INNER JOIN Post p ON c.fk_postid = p.postID WHERE p.postID = :postId AND c.status = :status", nativeQuery = true)
	long countCommentsByPostIdAndStatus(@Param("postId") Long postId, @Param("status") Integer status);

	@Query("SELECT le.post FROM Comment le WHERE le.user.id = :userId AND le.status = :status")
	List<Post> listcomment(@Param("userId") Long userId, @Param("status") Integer status);
}