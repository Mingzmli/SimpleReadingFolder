package com.simple.reading.admin.form.model;

import java.util.Date;
import java.util.UUID;

import com.simple.reading.admin.entities.ArticalEntity;

public class ArticleInfo {
	
	private String id;
	
	private String title;
	
	private String content;
	
	private Date createDate;
	
	private Date changeDate;
	
	private String userId;
	
	private UserInfo user;

	public ArticleInfo(){
		this.id = UUID.randomUUID().toString();
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

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getChangeDate() {
		return changeDate;
	}

	public void setChangeDate(Date changeDate) {
		this.changeDate = changeDate;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public UserInfo getUser() {
		return user;
	}

	public void setUser(UserInfo user) {
		this.user = user;
	}
	
	
	public void form(ArticalEntity articalEntity)
	{
		this.setId(articalEntity.getId());
		this.setUserId(articalEntity.getUserId());
		this.setTitle(articalEntity.getTitle());
		this.setContent(articalEntity.getContent());
		this.setCreateDate(articalEntity.getCreatedDate());
		this.setChangeDate(articalEntity.getChangedDate());


	}
	
	public void to(ArticalEntity articalEntity)
	{
		articalEntity.setId(this.getId());
		articalEntity.setUserId(this.getUserId());
		articalEntity.setTitle(this.getTitle());
		articalEntity.setContent(this.getContent());
		articalEntity.setCreatedDate(this.getCreateDate());
		articalEntity.setChangedDate(this.getChangeDate());

	}
	

}
