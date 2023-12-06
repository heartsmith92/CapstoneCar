package com.educlaas.xyzcar.entity;

import java.util.Date; // Import java.util.Date

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;


@Entity
@Data
@Table(name = "NotificationLog")
public class NotificationLog {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "logID")
    private Long logID;

	@ManyToOne
    @JoinColumn(name = "FK_userID")
    @JsonManagedReference 
    private User user;

    @Column(name = "NotificationType")
    private Integer notificationType;

    @Column(name = "createdDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @Column(name = "targetUserID")
    private Integer targetUserID;
    
    @Column(name = "postid")
    private Integer postid;


	
	
}
