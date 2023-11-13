package com.educlaas.xyzcar.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date; // Import java.util.Date
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userID")
    private Long id;

    @Column(name = "username", length = 50, unique = true) // Assuming usernames should be unique
    private String username;

    @Column(name = "firstName", length = 50)
    private String firstName;

    @Column(name = "lastName", length = 50)
    private String lastName;

    @Column(name = "password", length = 255)
    private String password;

    @Column(name = "email", length = 100)
    private String email;

    @Column(name = "userType", length = 20)
    private String userType;

    @Column(name = "createdDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate; // Change the type to java.util.Date


    @Column(name = "userBio", length = 255)
    private String userBio;

    @Column(name = "status")
    private Integer status;

    @Column(name = "profileImgPath", length = 255)
    private String profileImgPath;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    @JsonBackReference 
    private List<Community> communities;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    @JsonBackReference 
    private List<Post> posts;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    @JsonBackReference 
    private List<Comment> comments;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    @JsonBackReference 
    private List<LikeEntity> likes;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    @JsonBackReference 
    private List<Follow> follows;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    @JsonBackReference 
    private List<Share> shares;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    @JsonBackReference 
    private List<NotificationLog> notificationLogs;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    @JsonBackReference 
    private List<CommunityMember> communityMembers;
}
