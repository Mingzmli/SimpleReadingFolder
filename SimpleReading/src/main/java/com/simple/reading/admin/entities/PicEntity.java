package com.simple.reading.admin.entities;

import com.simple.reading.admin.form.model.PicInfo;

public class PicEntity {
	
	private String id;
	
	private String url;
	
	private boolean available;
	
	
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
	
	
	public void toDTO(PicInfo picInfo)
	{
		picInfo.setId(this.getId());
		picInfo.setUrl(this.getUrl());
		picInfo.setAvailable(this.isAvailable());
	}
	
	public void fromDTO(PicInfo picInfo)
	{
		this.setId(picInfo.getId());
		this.setUrl(picInfo.getUrl());
		this.setAvailable(picInfo.isAvailable());
	}
	
}
