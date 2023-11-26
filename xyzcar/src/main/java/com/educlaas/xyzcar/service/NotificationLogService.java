package com.educlaas.xyzcar.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.educlaas.xyzcar.entity.NotificationLog;
import com.educlaas.xyzcar.entity.Post;
import com.educlaas.xyzcar.entity.User;
import com.educlaas.xyzcar.repository.CommentRepository;
import com.educlaas.xyzcar.repository.LikeRepository;
import com.educlaas.xyzcar.repository.NotificationLogRepository;
import com.educlaas.xyzcar.repository.PostRepository;
import com.educlaas.xyzcar.repository.ShareRepository;
import com.educlaas.xyzcar.repository.UserRepository;

@Service
public class NotificationLogService {

    @Autowired
    private NotificationLogRepository notificationLogRepository;
    
    @Autowired
    private PostRepository postRepository;

    @Autowired
    private LikeRepository likeRepository;

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private ShareRepository shareRepository;
    
    @Autowired
    private UserRepository userRepository; // Added UserRepository
    
    
    public List<NotificationLog> getAllNotificationLogs() {
        return notificationLogRepository.findAll();
    }

    public Optional<NotificationLog> getNotificationLogById(Long id) {
        return notificationLogRepository.findById(id);
    }

    public NotificationLog createNotificationLog(NotificationLog notificationLog) {
        return notificationLogRepository.save(notificationLog);
    }

    public NotificationLog updateNotificationLog(NotificationLog notificationLog) {
        return notificationLogRepository.save(notificationLog);
    }

    public void deleteNotificationLog(Long id) {
        notificationLogRepository.deleteById(id);
    }
    
    
    public Map<String, Long> getPostTabulation(Long postId) {
        // Your logic to get counts for likes, comments, and shares

        // Example map with counts
        Map<String, Long> tabulation = new HashMap<>();
        tabulation.put("likeCount", likeRepository.countLikesByPostIdAndStatus(postId, 1)); // Assuming 1 is the status for likes
        tabulation.put("commentCount", commentRepository.countCommentsByPostIdAndStatus(postId, 1)); // Assuming 1 is the status for comments
        tabulation.put("shareCount", shareRepository.countSharesByPostIdAndStatus(postId, 1)); // Assuming 1 is the status for shares

        return tabulation;
    }

    



    
}
