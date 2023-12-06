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
@Table(name = "Share")
public class Share {
	

		@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "shareID")
	    private Long shareID;

	    @Column(name = "status")
	    private Integer status;

	    @Column(name = "createdDate")
	    @Temporal(TemporalType.TIMESTAMP)
	    private Date createdDate;

	    @ManyToOne
	    @JoinColumn(name = "FK_postID")
	    private Post post;

	    @ManyToOne
	    @JoinColumn(name = "FK_userID")
	    private User user;
}
