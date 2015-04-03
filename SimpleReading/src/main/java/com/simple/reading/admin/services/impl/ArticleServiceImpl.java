package com.simple.reading.admin.services.impl;

import java.util.List;

import com.simple.reading.admin.form.model.ArticleInfo;
import com.simple.reading.admin.services.ArticleService;
import com.simple.reading.admin.services.ArticleServiceHandle;

public class ArticleServiceImpl implements ArticleService{

	private ArticleServiceHandle articleServiceHandle;
	
	public ArticleServiceHandle getArticleServiceHandle() {
		return articleServiceHandle;
	}

	public void setArticleServiceHandle(ArticleServiceHandle articleServiceHandle) {
		this.articleServiceHandle = articleServiceHandle;
	}

	@Override
	public void addArticle(ArticleInfo articleInfo) {
		// TODO Auto-generated method stub
		 this.articleServiceHandle.addArticle(articleInfo);
	}

	@Override
	public List<ArticleInfo> getAllArticle() {
		// TODO Auto-generated method stub
		return this.articleServiceHandle.getAllArticle();
	}

	@Override
	public void deleteArticle(String id) {
		// TODO Auto-generated method stub
		this.articleServiceHandle.deleteArticle(id);
	}

	@Override
	public ArticleInfo getArticleById(String id) {
		// TODO Auto-generated method stub
		return this.articleServiceHandle.getArticleById(id);
	}

	@Override
	public void updateArticleById(ArticleInfo aritcleInfo) {
		// TODO Auto-generated method stub
		this.articleServiceHandle.updateArticleById(aritcleInfo);
	}

}
