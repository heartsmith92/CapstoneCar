package com.educlaas.xyzcar.dto;

import com.educlaas.xyzcar.entity.Post;
import com.educlaas.xyzcar.entity.User;

import lombok.Data;

@Data
public class CommentDTO {
	
	private Long commentID;
	private String comment;
	private Integer status;
	private User user;
	private Post post;
	private Integer targetUserID;
}
