package com.simple.reading.junit;

import java.io.File;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.simple.reading.admin.entities.PicEntity;
import com.simple.reading.admin.form.model.ArticleInfo;
import com.simple.reading.admin.form.model.PicInfo;
import com.simple.reading.admin.mapper.PicMapper;
import com.simple.reading.admin.services.PicService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/applicationContext.xml")
public class TestPic {

	@Autowired
	public PicMapper picMapper;

	@Autowired
	public PicService picService;

	
	@Test
	public void testDelete()
	{
		PicEntity picEntity = picMapper.getPicByUrl("/SimpleReading/attached/image/20150411/20150411232846_949.png");
		File file = new File(picEntity.getSavePath());
		if(file.exists())
		{
			file.delete();
		}
	}
	
	@Test
	public void testService() {

		// ApplicationContext act = new ClassPathXmlApplicationContext(
		// "/applicationContext.xml");
		
		ArticleInfo articleInfo = new ArticleInfo();
		 PicInfo picInfo = new PicInfo();
		 System.out.println(picInfo.getId());
		 picInfo.setUrl("www.tudou.com");
		 picInfo.setSavePath("www.tudou.com");
		 picInfo.setAvailable(false);
		 picInfo.setArticleId(articleInfo.getId());
		 picService.addPic(picInfo);

//		PicInfo picInfo = this.picService.getPicByUrl("www.taobao.com");
//		
//		if (picInfo == null) {
//			System.out.println("no data");
//		} else {
//			picInfo.setAvailable(true);
//
//			this.picService.updatePicByUrl(picInfo);
//		}
	}

	@Test
	public void testAddPic() {

		// ApplicationContext act = new ClassPathXmlApplicationContext(
		// "/applicationContext.xml");

		// PicMapper picMapper = (PicMapper)act.getBean("picMapper");

		// PicEntity picEntity= new PicEntity();
		//
		// picEntity.setUrl("www.baidu.com");
		// picEntity.setAvailable(false);
		//
		// picMapper.addPic(picEntity);

		PicEntity picEntity = picMapper.getPicByUrl("www.baidu.com");

		picEntity.setAvailable(true);

		picMapper.updatePicByUrl(picEntity);

	}
}
