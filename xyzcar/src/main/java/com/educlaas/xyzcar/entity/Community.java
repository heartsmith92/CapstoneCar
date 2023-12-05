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
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Entity
@Data
@Table(name = "Community")
public class Community {
	
	

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "communityID")
    private Long communityID;

    @Column(name = "communityName", length = 45)
    private String communityName;

    @Column(name = "communityBio", length = 255)
    private String communityBio;

    @Column(name = "createdDate", length = 45)
    private Date createdDate;

    @Column(name = "status", length = 45)
    private Integer status;

    @Column(name = "communityLogoPath", length = 45)
    private String communityLogoPath;

    @ManyToOne
    @JoinColumn(name = "FK_userID")
    @JsonManagedReference 
    private User user;

    @OneToMany(mappedBy = "community", cascade = CascadeType.ALL)
    @JsonBackReference 
    private List<Post> posts;

    @OneToMany(mappedBy = "community", cascade = CascadeType.ALL)
    @JsonBackReference 
    private List<CommunityMember> communityMembers;

}
