package com.simple.reading.junit;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.simple.reading.admin.entities.ArticalEntity;
import com.simple.reading.admin.entities.UserEntity;
import com.simple.reading.admin.form.model.ArticleInfo;
import com.simple.reading.admin.form.model.UserInfo;
import com.simple.reading.admin.mapper.ArticalMapper;
import com.simple.reading.admin.mapper.UserMapper;
import com.simple.reading.admin.services.AdminServcie;
import com.simple.reading.admin.services.ArticleService;
import com.simple.reading.utils.JsonHelper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/applicationContext.xml")
public class TestAritical {
	@Autowired
	public UserMapper userMapper;

	@Autowired
	public ArticalMapper articalMapper;

	@Autowired
	private AdminServcie adminServcie;

	@Autowired
	public ArticleService articleService;

	
	
	
	@Test
	public void testGetAllArticles(){
		
		List<ArticleInfo> ArticleInfos = articleService.getAllArticle();
		
		for(ArticleInfo articleInfo :ArticleInfos)
		{
			System.out.println(articleInfo.getId());
		}
		
		
	}
	
	
	@Test
	public void testArticleService() {

		UserInfo userInfo = new UserInfo();

		userInfo.setUsername("SimpleReadingAdmin");
		;

		UserInfo userInfoDb = adminServcie.getUser(userInfo);

		ArticleInfo articleInfo = new ArticleInfo();

		articleInfo.setTitle("Title.......");

		articleInfo.setContent("Content..........");

		articleInfo.setUserId(userInfoDb.getId());

		articleInfo.setCreateDate(new Date());

		articleInfo.setChangeDate(new Date());

		articleService.addArticle(articleInfo);

	}

	@Test
	public void testGetUserWithArtical() {

		UserEntity userEntity = userMapper
				.getUserById("3a237618-b74b-11e4-962a-005056c00008");

		for (ArticalEntity artical : userEntity.getArticalEntities()) {
			System.out.println(artical.getUserId());
		}
	}

	@Test
	public void testAddArticalWithExitUser() {

		UserEntity userEntity = userMapper
				.getUserByUsername("SimpleReadingAdmin");
		System.out.println(userEntity.getId());
		System.out.println(userEntity.getUsername());
		System.out.println(userEntity.getPassword());
		System.out.println(userEntity.getRoleLevel());
		//
		// List<UserEntity> userEntities = userMapper.getUserAll();
		//
		// for(UserEntity userEntity : userEntities)
		// {
		// System.out.println(userEntity.getId());
		// System.out.println(userEntity.getUsername());
		// System.out.println(userEntity.getPassword());
		// System.out.println(userEntity.getRoleLevel());
		//
		// }

		ArticalEntity articalEntity = new ArticalEntity();

		articalEntity.setTitle("testArtical3");
		articalEntity.setContent("testAritical Content3");
		articalEntity.setCreatedDate(new Date());
		articalEntity.setChangedDate(new Date());
		articalEntity.setUserId(userEntity.getId());
		System.out.println(articalEntity.getUserId());
		articalMapper.addArtical(articalEntity);
		System.out.println("Aritical Id: " + articalEntity.getId());

	}

	@Test
	public void testGetAriticalById() {
		ArticalEntity articalEntity = articalMapper
				.getArticalById("5fd5ffb0-b746-11e4-962a-005056c00008");

		System.out.println(articalEntity.getId());

	}

	@Test
	public void testDeleteAritcial() {
		UserEntity userEntity = userMapper
				.getUserById("9762bfee-b742-11e4-962a-005056c00008");

		ArticalEntity articalEntity = articalMapper
				.getArticalById("98629116-b742-11e4-962a-005056c00008");
		//articalMapper.deleteArtical(articalEntity);
	}

	@Test
	public void testDeleteUser() {
		UserEntity userEntity = userMapper
				.getUserById("1bb293bc-b746-11e4-962a-005056c00008");
		if (userEntity == null) {
			System.out.println("model null");
		} else {
			userMapper.deleteUserByUsername(userEntity);
		}
	}

	@Test
	public void testAddAritical() {

		if (articalMapper == null) {
			System.out.println("articalMapper null");
		}

		else {
			System.out.println(articalMapper);

			UserEntity userEntity = this.getUserEntity();

			userMapper.addUser(userEntity);
			System.out.println("id:  " + userEntity.getId());
			ArticalEntity articalEntity = new ArticalEntity();

			articalEntity.setTitle("testArtical2");
			articalEntity.setTitle("testing title2");
			articalEntity.setContent("testAritical Content2");
			articalEntity.setCreatedDate(new Date());
			articalEntity.setChangedDate(new Date());
			articalEntity.setUserId(userEntity.getId());

			articalMapper.addArtical(articalEntity);

		}
	}

	@Test
	public void testJsonHelper(){
		String jsonStr = JsonHelper.Obejct2Json(this.getUserEntity());
		
		System.out.println(jsonStr);
		
		UserEntity userEntity = (UserEntity) JsonHelper.Json2Objext(jsonStr, UserEntity.class);
		
		System.out.println(userEntity.getUsername());
		System.out.println(userEntity.getPassword());
		System.out.println(userEntity.getRoleLevel());
		
		Map<String,Object> map= (Map) JsonHelper.Json2Objext(jsonStr, Map.class);
		
		System.out.println(map);
	}
	
	
	
	public static UserEntity getUserEntity() {
		UserEntity userEntity = new UserEntity();

		userEntity.setUsername("ming");
		userEntity.setPassword("123");
		userEntity.setRoleLevel(1);
		return userEntity;
	}

	@Test
	public void testDeleteAll() {
		List<UserEntity> users = userMapper.getUserAll();

		for (UserEntity user : users) {
			userMapper.deleteUserByUsername(user);
		}

	}
}
