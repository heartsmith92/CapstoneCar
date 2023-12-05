package com.educlaas.xyzcar.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.educlaas.xyzcar.entity.LikeEntity;
import com.educlaas.xyzcar.entity.NotificationLog;
import com.educlaas.xyzcar.entity.Post;

public interface NotificationLogRepository extends JpaRepository<NotificationLog, Long> {
	Optional<NotificationLog> findById(Long postID);
	LikeEntity save(LikeEntity like);
	
    List<NotificationLog> findByUser_Id(Long userId);
	
}