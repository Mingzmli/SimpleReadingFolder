package com.simple.reading.admin.entities;

import java.io.Serializable;
import java.util.Date;

public class ArticalEntity implements Serializable{

	private static final long serialVersionUID = -5348123311604867350L;
	
	private String id;
	
	private String title;
	
	private String content;
	
	private Date createdDate;
	
	private Date changedDate;
	
	private String readSavePath;
	/*
	 * foreign key
	 */
	private String userId;
	
	private UserEntity userEntity;

	
	public String getReadSavePath() {
		return readSavePath;
	}

	public void setReadSavePath(String readSavePath) {
		this.readSavePath = readSavePath;
	}

	public Date getChangedDate() {
		return changedDate;
	}

	public void setChangedDate(Date changedDate) {
		this.changedDate = changedDate;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}


	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public UserEntity getUserEntity() {
		return userEntity;
	}

	public void setUserEntity(UserEntity userEntity) {
		this.userEntity = userEntity;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
