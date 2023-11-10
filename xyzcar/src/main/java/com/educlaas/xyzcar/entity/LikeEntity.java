package com.educlaas.xyzcar.entity;

import java.util.Date; // Import java.util.Date

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
@Table(name = "LikeEntity")
public class LikeEntity {
	
	 @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "likeID")
    private Long likeID;

    @Column(name = "createdDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @Column(name = "status")
    private Integer status;

    @ManyToOne
    @JoinColumn(name = "FK_userID")
    private User user;

    @ManyToOne
    @JoinColumn(name = "FK_postID")
	    private Post post;
}
