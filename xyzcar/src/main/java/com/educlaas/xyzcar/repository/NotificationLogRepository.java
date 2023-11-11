package com.educlaas.xyzcar.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.educlaas.xyzcar.entity.NotificationLog;

public interface NotificationLogRepository extends JpaRepository<NotificationLog, Long> {
    // You can add custom query methods here if needed
}