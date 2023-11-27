package com.educlaas.xyzcar.repository;


import java.util.List;



import java.util.List;

import java.util.Optional;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.educlaas.xyzcar.entity.Comment;
import com.educlaas.xyzcar.entity.LikeEntity;
import com.educlaas.xyzcar.entity.Post;
import com.educlaas.xyzcar.entity.Share;
import com.educlaas.xyzcar.entity.User;

public interface PostRepository extends JpaRepository<Post, Long> {

    // You can add custom query methods here if needed
	

    @Query("SELECT p FROM Post p WHERE p.status = :status")
    List<Post> findByStatus(@Param("status") int status);
	

	
//    @Query("SELECT p FROM Post p WHERE p.user.id = :userId")
//    List<Post> findPostsByUserId(@Param("userId") Long userId);
//    
	
	 @Query("SELECT p FROM Post p WHERE p.user.id = :userId AND (:status IS NULL OR p.status = :status)")
	  List<Post> findPostsByUserIdAndStatus(@Param("userId") Long userId, @Param("status") Integer status);

	Optional<Post> findById(Long postID);
	LikeEntity save(LikeEntity like);
	Share save(Share like);
	Comment save(Comment comment);


}