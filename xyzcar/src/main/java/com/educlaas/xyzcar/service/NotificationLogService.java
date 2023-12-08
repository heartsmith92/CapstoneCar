package com.educlaas.xyzcar.service;

import java.util.HashMap;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.educlaas.xyzcar.entity.Community;
import com.educlaas.xyzcar.entity.LikeEntity;
import com.educlaas.xyzcar.entity.NotificationLog;
import com.educlaas.xyzcar.entity.Post;
import com.educlaas.xyzcar.entity.User;
import com.educlaas.xyzcar.repository.CommentRepository;
import com.educlaas.xyzcar.repository.LikeRepository;
import com.educlaas.xyzcar.repository.NotificationLogRepository;
import com.educlaas.xyzcar.repository.PostRepository;
import com.educlaas.xyzcar.repository.ShareRepository;
import com.educlaas.xyzcar.repository.UserRepository;
import com.educlaas.xyzcar.repository.NotificationLogRepository;
import com.educlaas.xyzcar.repository.PostRepository;
import com.educlaas.xyzcar.repository.ShareRepository;

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

    
    public List<NotificationLog> getNotificationLogsByFkUserIdAndPostId(Long fkUserId, Long postId) {
        return notificationLogRepository.findByUser_IdAndPostid(fkUserId, postId);
    }    



    //Function16 Add likes to NotificationLog
    @Autowired
    private NotificationLogRepository notificationLogRepository1;

    public NotificationLog addLikesToNL(User user, Post post, Integer targetUserId, int notificationType) {
        NotificationLog notificationLog = new NotificationLog();
        notificationLog.setCreatedDate(new Date());
        notificationLog.setUser(user);
        notificationLog.setPost(post);
        notificationLog.setTargetUserID(targetUserId);
        
        // Set notification type based on the action (like = 0, dislike = 1)
        if (notificationType == 0 || notificationType == 1) {
            notificationLog.setNotificationType(notificationType);
        } else {
            throw new IllegalArgumentException("Invalid notification type");
        }

        // Set other attributes in the notification log as needed
        
        NotificationLog addedNotificationLog = notificationLogRepository.save(notificationLog);

        return addedNotificationLog;
    
    }
    
  //Function19 Add Share to NotificationLog
   

    public NotificationLog shareToNL(User user, Post post, Integer targetUserId, int notificationType) {
        NotificationLog notificationLog = new NotificationLog();
        notificationLog.setCreatedDate(new Date());
        notificationLog.setUser(user);
        notificationLog.setPost(post);
        notificationLog.setTargetUserID(targetUserId);
        
        // Set notification type based on the action (3=share)
        if (notificationType == 3 ) {
            notificationLog.setNotificationType(notificationType);
        } else {
            throw new IllegalArgumentException("Invalid notification type");
        }

        // Set other attributes in the notification log as needed
        
        NotificationLog addedNotificationLog = notificationLogRepository.save(notificationLog);

        return addedNotificationLog;
    
    }
    
  //Function18 Add Comment to NotificationLog
    

    public NotificationLog commentToNL(User user, Post post, Integer targetUserId, int notificationType) {
        NotificationLog notificationLog = new NotificationLog();
        notificationLog.setCreatedDate(new Date());
        notificationLog.setUser(user);
        notificationLog.setPost(post);
        notificationLog.setTargetUserID(targetUserId);
        
        // Set notification type based on the action (2=comments)
        if (notificationType == 2 ) {
            notificationLog.setNotificationType(notificationType);
        } else {
            throw new IllegalArgumentException("Invalid notification type");
        }

        // Set other attributes in the notification log as needed
        
        NotificationLog addedNotificationLog = notificationLogRepository.save(notificationLog);

        return addedNotificationLog;
    
    }
    
//Function7 Add Member to NotificationLog
    

    public NotificationLog memberToNL(User user, Community community, Integer targetUserId, int notificationType) {
        NotificationLog notificationLog = new NotificationLog();
        notificationLog.setCreatedDate(new Date());
        notificationLog.setUser(user);
        notificationLog.setTargetUserID(targetUserId);
        
        // Set notification type based on the action (2=comments)
        if (notificationType == 6 ) {
            notificationLog.setNotificationType(notificationType);
        } else {
            throw new IllegalArgumentException("Invalid notification type");
        }

        // Set other attributes in the notification log as needed
        
        NotificationLog addedNotificationLog = notificationLogRepository.save(notificationLog);

        return addedNotificationLog;
    
    }
    
    
    //    findByUserId
    public List<NotificationLog> getNotificationLogsByFkUserId(Long fkUserId) {
        return notificationLogRepository.findByUserId(fkUserId);
    }
}
    

