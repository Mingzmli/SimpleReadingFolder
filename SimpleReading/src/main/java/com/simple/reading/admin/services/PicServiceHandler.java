package com.simple.reading.admin.services;

import java.util.List;

import com.simple.reading.admin.form.model.PicInfo;

public interface PicServiceHandler {
	
	public PicInfo getPicByUrl(String url);

	public void addPic(PicInfo picInfo);

	public void updatePicByUrl(PicInfo picInfo);
	
	public List<PicInfo> getPicByArticleId(String articleId);
}
