package com.simple.reading.admin.entities;

import java.util.UUID;

import com.simple.reading.admin.form.model.PicInfo;

public class PicEntity {
	
	private String id;
	
	private String url;
	
	private String savePath;
	
	private boolean available;
	
	private String articleId;
	
		

	public String getArticleId() {
		return articleId;
	}
	public void setArticleId(String articleId) {
		this.articleId = articleId;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}

	public boolean isAvailable() {
		return available;
	}
	public void setAvailable(boolean available) {
		this.available = available;
	}
	
	
	public String getSavePath() {
		return savePath;
	}
	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}
	public void toDTO(PicInfo picInfo)
	{
		picInfo.setId(this.getId());
		picInfo.setUrl(this.getUrl());
		picInfo.setAvailable(this.isAvailable());
		picInfo.setSavePath(this.getSavePath());

		picInfo.setArticleId(this.getArticleId());
	}
	
	public void fromDTO(PicInfo picInfo)
	{
		this.setId(picInfo.getId());
		this.setUrl(picInfo.getUrl());
		this.setAvailable(picInfo.isAvailable());
		this.setSavePath(picInfo.getSavePath());		
		this.setArticleId(picInfo.getArticleId());
	}
	
}
