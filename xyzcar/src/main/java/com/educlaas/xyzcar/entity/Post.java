package com.educlaas.xyzcar.entity;

import java.util.Date; // Import java.util.Date
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Data
@Table(name = "Post")
public class Post {
	

		@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "postID")
	    private Long postID;

	    @Column(name = "createdDate")
	    @Temporal(TemporalType.TIMESTAMP)
	    private Date createdDate;

	    @Column(name = "postTitle", length = 255)
	    private String postTitle;

	    @Column(name = "postContent", length = 255)
	    private String postContent;

	    @Column(name = "postImgPath", length = 255)
	    private String postImgPath;

	    @Column(name = "status")
	    private Integer status;

	    @Column(name = "postType", length = 50)
	    private String postType;

	    @ManyToOne
	    @JoinColumn(name = "FK_userID")
	    @JsonManagedReference 
	    private User user;

	    @ManyToOne
	    @JoinColumn(name = "FK_communityID")
	    @JsonManagedReference 
	    private Community community;

	    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
	    @JsonBackReference 
	    private List<Comment> comments;

	    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
	    private List<LikeEntity> likes;

	    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
	    @JsonBackReference 
	    private List<Share> shares;
	

}
