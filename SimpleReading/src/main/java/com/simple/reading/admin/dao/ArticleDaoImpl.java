package com.simple.reading.admin.dao;

import java.util.ArrayList;
import java.util.List;

import com.simple.reading.admin.entities.ArticalEntity;
import com.simple.reading.admin.form.model.ArticleInfo;

public class ArticleDaoImpl implements ArticleDao{

	
	private AdminContext  adminContext;
	
	public AdminContext getAdminContext() {
		return adminContext;
	}

	public void setAdminContext(AdminContext adminContext) {
		this.adminContext = adminContext;
	}

	@Override
	public void AddArticle(ArticleInfo articleInfo) {
		
		// TODO Auto-generated method stub
		
		ArticalEntity articalEntity = new ArticalEntity();
	
		articleInfo.to(articalEntity);
				
		 this.adminContext.getArticalMapper().addArtical(articalEntity);
		
	}

	@Override
	public List<ArticleInfo> getAllArticle() {
		
		List<ArticalEntity> articalEnties = this.adminContext.getArticalMapper().getAllArtical();
		
		List<ArticleInfo> articleInfos = new ArrayList<ArticleInfo>();
		
		for(ArticalEntity articalEntity : articalEnties)
		{
			
			ArticleInfo articleInfo = new ArticleInfo();
			 
			articleInfo.form(articalEntity);
			
			articleInfos.add(articleInfo);
		}
		return articleInfos;
	}

	
	@Override
	public void deleteArticle(String id) {
		// TODO Auto-generated method stub
		this.adminContext.getArticalMapper().deleteArtical(id);
	}

	@Override
	public ArticleInfo getArticleById(String id) {
		// TODO Auto-generated method stub\
		ArticleInfo articleInfo = new ArticleInfo();
		ArticalEntity articalEntity = this.adminContext.getArticalMapper().getArticalById(id);
		articleInfo.form(articalEntity);		
		return articleInfo;
	}
}
