package com.simple.reading.admin.dao;

import java.util.List;

import com.simple.reading.admin.form.model.PicInfo;

public interface PicDao {
	
	public PicInfo getPicByUrl(String url);
	
	public void addPic(PicInfo picInfo);
	
	public void updatePicByUrl(PicInfo picInfo);	
	
	public List<PicInfo> getPicByArticleId(String articleId);
}
