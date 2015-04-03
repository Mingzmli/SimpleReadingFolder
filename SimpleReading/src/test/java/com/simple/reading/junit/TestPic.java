package com.simple.reading.junit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.simple.reading.admin.entities.PicEntity;
import com.simple.reading.admin.mapper.PicMapper;
import com.simple.reading.admin.mapper.UserMapper;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/applicationContext.xml")
public class TestPic {

	@Autowired
	public PicMapper picMapper;
	
	@Test
	public void testAddPic(){
		
//		ApplicationContext act = new ClassPathXmlApplicationContext(
//				"/applicationContext.xml");
		
//		PicMapper picMapper =  (PicMapper)act.getBean("picMapper");
		
//		PicEntity picEntity= new PicEntity();
//		
//		picEntity.setUrl("www.baidu.com");
//		picEntity.setAvailable(false);
//		
//		picMapper.addPic(picEntity);
		
		PicEntity picEntity = picMapper.getPicByUrl("www.baidu.com");
		
		picEntity.setAvailable(true);
		
		picMapper.updatePicByUrl(picEntity);
		
	}
}
