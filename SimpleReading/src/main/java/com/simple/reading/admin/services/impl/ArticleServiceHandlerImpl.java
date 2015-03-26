package com.simple.reading.admin.services.impl;

import java.util.Date;
import java.util.List;

import com.simple.reading.admin.dao.ArticleDao;
import com.simple.reading.admin.form.model.ArticleInfo;
import com.simple.reading.admin.services.ArticleServiceHandle;

public class ArticleServiceHandlerImpl implements ArticleServiceHandle{

	private ArticleDao articleDao;
		
	public ArticleDao getArticleDao() {
		return articleDao;
	}

	public void setArticleDao(ArticleDao articleDao) {
		this.articleDao = articleDao;
	}

	@Override
	public void addArticle(ArticleInfo articleInfo) {
		articleInfo.setChangeDate(new Date());
		articleInfo.setCreateDate(new Date());
		 this.articleDao.AddArticle(articleInfo);
	}

	@Override
	public List<ArticleInfo> getAllArticle() {
		// TODO Auto-generated method stub
		return this.articleDao.getAllArticle();
	}

	@Override
	public void deleteArticle(String id) {
		// TODO Auto-generated method stub
		this.articleDao.deleteArticle(id);
	}

	@Override
	public ArticleInfo getArticleById(String id) {
		// TODO Auto-generated method stub
		
		return this.articleDao.getArticleById(id);
	}
	
	
	
	

}
