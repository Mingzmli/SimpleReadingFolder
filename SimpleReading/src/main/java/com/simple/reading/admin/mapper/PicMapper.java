package com.simple.reading.admin.mapper;

import com.simple.reading.admin.entities.PicEntity;

public interface PicMapper {
	
	public PicEntity getPicByUrl(String url);
	
	public void addPic(PicEntity picEntity);
	
	public void updatePicByUrl(PicEntity picEntity);
}
