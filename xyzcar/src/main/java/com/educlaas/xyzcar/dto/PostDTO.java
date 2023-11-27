package com.educlaas.xyzcar.dto;

import java.util.Date;

import lombok.Data;

@Data
public class PostDTO {

	private Long likeId;
    private Integer status;
    private Integer user;
    private Integer post;
    private Integer targetUserID;
}
