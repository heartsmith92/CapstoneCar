package com.educlaas.xyzcar.dto;
import java.util.Date;
import lombok.Data;

@Data
public class CreateCommunityDTO {
	private String communityName;
	private String communityBio;
	private Integer status;
	private String communityLogoPath;
	
	
}
