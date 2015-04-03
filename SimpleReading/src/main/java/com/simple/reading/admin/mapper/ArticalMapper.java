package com.simple.reading.admin.mapper;

import java.util.List;

import com.simple.reading.admin.entities.ArticalEntity;

public interface ArticalMapper {

	public void addArtical(ArticalEntity articalEntity);
	
	public ArticalEntity getArticalById(String id);
	
	public List<ArticalEntity> getArticalByUserId(String userId);
	
	public void updateArticalById(ArticalEntity articalEntity);
	
	public void deleteArtical(String id);
	
	public List<ArticalEntity> getAllArtical();

}
