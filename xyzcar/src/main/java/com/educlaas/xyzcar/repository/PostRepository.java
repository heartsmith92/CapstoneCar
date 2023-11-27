package com.educlaas.xyzcar.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.educlaas.xyzcar.entity.LikeEntity;
import com.educlaas.xyzcar.entity.Post;
import com.educlaas.xyzcar.entity.User;

public interface PostRepository extends JpaRepository<Post, Long> {
	Optional<Post> findById(Long postID);
	LikeEntity save(LikeEntity like);
}