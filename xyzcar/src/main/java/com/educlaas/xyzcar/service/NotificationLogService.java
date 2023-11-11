package com.educlaas.xyzcar.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educlaas.xyzcar.entity.NotificationLog;
import com.educlaas.xyzcar.repository.NotificationLogRepository;

@Service
public class NotificationLogService {

    @Autowired
    private NotificationLogRepository notificationLogRepository;

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
}
