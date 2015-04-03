package com.simple.reading.admin.services;

import java.util.List;

import com.simple.reading.admin.form.model.ArticleInfo;

public interface ArticleServiceHandle {
	
	public void addArticle(ArticleInfo articleInfo);
	
	public List<ArticleInfo> getAllArticle();
	
	public void deleteArticle(String id);
	
	public ArticleInfo getArticleById(String id);
	
	public void updateArticleById(ArticleInfo aritcleInfo);
}
