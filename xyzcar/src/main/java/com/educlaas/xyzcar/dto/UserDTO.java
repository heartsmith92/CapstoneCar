package com.educlaas.xyzcar.dto;

import java.util.Date;

import lombok.Data;

@Data
public class UserDTO {
	   private Long id;
	    private String username;
	    private String password;
	    private String firstName;
	    private String lastName;
	    private String email;
	    private Date createdDate;
	    private String userType;
	    private Integer notificationStatus;
	    private String userBio;
	    private Integer status;
	    private String profileImgPath;

}
