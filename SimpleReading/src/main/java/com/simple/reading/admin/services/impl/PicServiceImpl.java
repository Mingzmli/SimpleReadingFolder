package com.simple.reading.admin.services.impl;

import java.util.List;

import com.simple.reading.admin.form.model.PicInfo;
import com.simple.reading.admin.services.PicService;
import com.simple.reading.admin.services.PicServiceHandler;

public class PicServiceImpl implements PicService{

	private PicServiceHandler picServiceHandler;
	
	public PicServiceHandler getPicServiceHandler() {
		return picServiceHandler;
	}

	public void setPicServiceHandler(PicServiceHandler picServiceHandler) {
		this.picServiceHandler = picServiceHandler;
	}

	@Override
	public PicInfo getPicByUrl(String url) {
		// TODO Auto-generated method stub
		return this.picServiceHandler.getPicByUrl(url);
	}

	@Override
	public void addPic(PicInfo picInfo) {
		// TODO Auto-generated method stub
		this.picServiceHandler.addPic(picInfo);
	}

	@Override
	public void updatePicByUrl(PicInfo picInfo) {
		// TODO Auto-generated method stub
		this.picServiceHandler.updatePicByUrl(picInfo);
	}

	@Override
	public List<PicInfo> getPicByArticleId(String articleId) {
		// TODO Auto-generated method stub
		return this.picServiceHandler.getPicByArticleId(articleId);
	}
	
	
}
