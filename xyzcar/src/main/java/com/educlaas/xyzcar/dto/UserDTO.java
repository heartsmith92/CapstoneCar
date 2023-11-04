package com.educlaas.xyzcar.dto;

public class UserDTO {
	private Long id;
	private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String profileImage;
    
   

	public UserDTO() {
    }

    public UserDTO(Long id, String username, String password, String firstName, String lastName, String profileImage) {
    	this.id = id;
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.profileImage = profileImage;
    }

    // Constructors, getters, and setters
    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
    public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getProfileImage() {
		return profileImage;
	}

	public void setProfileImage(String profileImage) {
		this.profileImage = profileImage;
	}
}
