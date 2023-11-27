package com.educlaas.xyzcar.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.educlaas.xyzcar.entity.Comment;
import com.educlaas.xyzcar.entity.Post;

public interface CommentRepository extends JpaRepository<Comment, Long> {
	@Query("SELECT le.post FROM Comment le WHERE le.user.id = :userId AND le.status = :status")
	List<Post> listcomment(@Param("userId") Long userId, @Param("status") Integer status);
}