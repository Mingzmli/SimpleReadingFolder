package com.simple.reading.admin.dao;

import java.util.List;

import com.simple.reading.admin.entities.ArticalEntity;
import com.simple.reading.admin.form.model.ArticleInfo;

public interface ArticleDao {
	
	public void AddArticle(ArticleInfo aritcleInfo);
	
	public List<ArticleInfo> getAllArticle();
	
	public void deleteArticle(String id);
	
	public ArticleInfo getArticleById(String id);
	
	public void updateArticleById(ArticleInfo aritcleInfo);
}
