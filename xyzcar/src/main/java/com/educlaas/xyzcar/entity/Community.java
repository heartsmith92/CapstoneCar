package com.educlaas.xyzcar.entity;

import java.util.Date; // Import java.util.Date
import java.util.List;

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

    @Column(name = "communityBio", length = 45)
    private String communityBio;

    @Column(name = "createdDate", length = 45)
    private String createdDate;

    @Column(name = "status", length = 45)
    private String status;

    @Column(name = "communityLogoPath", length = 45)
    private String communityLogoPath;

    @ManyToOne
    @JoinColumn(name = "FK_userID")
    private User user;

    @OneToMany(mappedBy = "community", cascade = CascadeType.ALL)
    private List<Post> posts;

    @OneToMany(mappedBy = "community", cascade = CascadeType.ALL)
    private List<CommunityMember> communityMembers;
	

}
