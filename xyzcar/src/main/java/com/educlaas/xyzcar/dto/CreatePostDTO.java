package com.educlaas.xyzcar.dto;

import lombok.Data;

@Data
public class CreatePostDTO {
	
	private String postContent;
    private String postImgPath;
    private String postTitle;
    private String postType;
    private Integer status;
    private Long communityId;

}
