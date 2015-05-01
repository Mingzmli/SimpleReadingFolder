package com.simple.reading.admin.form.model;

import java.util.UUID;

public class PicInfo {
	
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
	
	
	public PicInfo(){
		this.id = UUID.randomUUID().toString();
	}
	
	public String getSavePath() {
		return savePath;
	}
	public void setSavePath(String savePath) {
		this.savePath = savePath;
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
	

	
	
}
