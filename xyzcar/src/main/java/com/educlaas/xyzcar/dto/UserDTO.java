package com.educlaas.xyzcar.dto;

import lombok.Data;

@Data
public class UserDTO {
	   private Long id;
	    private String username;
	    private String password;
	    private String firstName;
	    private String lastName;
	    private String email;
	    private String userType;
	    private String userBio;
	    private Integer status;
	    private String profileImage;

}
