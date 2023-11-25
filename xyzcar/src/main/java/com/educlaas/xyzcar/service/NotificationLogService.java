package com.educlaas.xyzcar.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educlaas.xyzcar.entity.LikeEntity;
import com.educlaas.xyzcar.entity.NotificationLog;
import com.educlaas.xyzcar.entity.Post;
import com.educlaas.xyzcar.entity.User;
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
    private ShareRepository shareRepository;

   

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
    
    
    //Function 21 
    public void createNotificationLog(Long userId, Long postId,Integer targetUserId) {
    	
    }
    
    //Function16 Add likes to NotificationLog
    @Autowired
    private NotificationLogRepository notificationLogRepository1;

    public NotificationLog addLikesToNL(User user, Post post, Integer targetUserId, int notificationType) {
        NotificationLog notificationLog = new NotificationLog();
        notificationLog.setCreatedDate(new Date());
        notificationLog.setUser(user);
        notificationLog.setTargetUserID(targetUserId);
        
        // Set notification type based on the action (like = 1, dislike = 2)
        if (notificationType == 1 || notificationType == 2) {
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
}
    

