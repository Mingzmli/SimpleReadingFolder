package com.simple.reading.admin.dao;

import java.util.ArrayList;
import java.util.List;

import com.simple.reading.admin.entities.PicEntity;
import com.simple.reading.admin.form.model.PicInfo;

public class PicDaoImpl implements PicDao {

	private AdminContext adminContext;

	public AdminContext getAdminContext() {
		return adminContext;
	}

	public void setAdminContext(AdminContext adminContext) {
		this.adminContext = adminContext;
	}

	@Override
	public PicInfo getPicByUrl(String url) {
		// TODO Auto-generated method stub
		try {
			PicEntity picEntity = this.getAdminContext().getPicMapper()
					.getPicByUrl(url);

			PicInfo picInfo = new PicInfo();

			picEntity.toDTO(picInfo);

			return picInfo;

		} catch (NullPointerException e) {

			return null;
		}

	}

	@Override
	public void addPic(PicInfo picInfo) {
		// TODO Auto-generated method stub
		PicEntity picEntity = new PicEntity();

		picEntity.fromDTO(picInfo);

		this.adminContext.getPicMapper().addPic(picEntity);
	}

	@Override
	public void updatePicByUrl(PicInfo picInfo) {
		// TODO Auto-generated method stub
		PicEntity picEntity = new PicEntity();

		picEntity.fromDTO(picInfo);

		this.adminContext.getPicMapper().updatePicByUrl(picEntity);

	}

	@Override
	public List<PicInfo> getPicByArticleId(String articleId) {
		// TODO Auto-generated method stub
		
		List<PicEntity> PicEntities = this.adminContext.getPicMapper().getPicByArticleId(articleId);
		
		List<PicInfo> PicInfos = new ArrayList<PicInfo>();
		
		for(PicEntity picEntity : PicEntities){
			
			PicInfo picInfo = new PicInfo();
			
			picEntity.toDTO(picInfo);
			
			PicInfos.add(picInfo);
			
		}
		
		return PicInfos;
	}

}
