package com.educlaas.xyzcar.entity;

import java.util.Date; // Import java.util.Date

import com.fasterxml.jackson.annotation.JsonBackReference;
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
@Table(name = "Comment")
public class Comment {
	
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "commentID")
    private Long commentID;

    @Column(name = "comment", length = 255)
    private String comment;

    @Column(name = "createdDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @Column(name = "status")
    private Integer status;

    @ManyToOne
    @JoinColumn(name = "FK_userID")
    @JsonManagedReference 
    private User user;

    @ManyToOne
    @JoinColumn(name = "FK_postID")
    @JsonManagedReference 
    private Post post;

}
