package com.simple.reading.admin.services.impl;

import java.util.List;

import com.simple.reading.admin.dao.PicDao;
import com.simple.reading.admin.form.model.PicInfo;
import com.simple.reading.admin.services.PicServiceHandler;

public class PicServiceHandlerImpl implements PicServiceHandler{

	private PicDao picDao;
	
	public PicDao getPicDao() {
		return picDao;
	}

	public void setPicDao(PicDao picDao) {
		this.picDao = picDao;
	}

	@Override
	public PicInfo getPicByUrl(String url) {
		// TODO Auto-generated method stub
		
		return this.picDao.getPicByUrl(url);
	}

	@Override
	public void addPic(PicInfo picInfo) {
		// TODO Auto-generated method stub
		this.picDao.addPic(picInfo);
	}

	@Override
	public void updatePicByUrl(PicInfo picInfo) {
		// TODO Auto-generated method stub
		this.picDao.updatePicByUrl(picInfo);
	}

	@Override
	public List<PicInfo> getPicByArticleId(String articleId) {
		// TODO Auto-generated method stub
		return this.picDao.getPicByArticleId(articleId);
	}

	
}
