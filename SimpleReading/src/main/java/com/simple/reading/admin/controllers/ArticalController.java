package com.simple.reading.admin.controllers;

import java.io.File;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.simple.reading.admin.form.model.ArticleInfo;
import com.simple.reading.admin.form.model.UserInfo;
import com.simple.reading.admin.services.ArticleService;
import com.simple.reading.utils.JsonHelper;
import com.simple.reading.utils.JsonResponse;
import com.simple.reading.utils.ScopeHelper;
import com.simple.reading.utils.SimpleHelper;

@Controller
public class ArticalController {

	private final static String CONTROLLER = "/simpleslty6435simpleartical";
	// request path
	private final static String ARTICLE_INDEX_REQUEST = CONTROLLER + "/index";

	private final static String ARTICLE_ADD_REQUEST = CONTROLLER
			+ "/addartical";

	private final static String ARTICLE_DELETE_REQUEST = CONTROLLER
			+ "/deleteartical";

	private final static String UPLOAD_JSON = CONTROLLER + "/uploadJson";

	// Redirect
	private final static String REDIRECT = "redirect:";

	private final static String REDIRECT_ARTICLE_INDEX_REQUEST = REDIRECT
			+ ARTICLE_INDEX_REQUEST;

	// view path
	private final static String ARTICLE_INDEX_VIEW = "manageartical/artical-index";

	private final static String ADD_ARTICAL_VIEW = "manageartical/artical-add";

	private final static String UPLOAD_JSON_VIEW = "upload_json";

	// *************************************************************************
	@Autowired
	private ArticleService articleService;

	@RequestMapping(value = ARTICLE_INDEX_REQUEST, method = { RequestMethod.GET })
	public ModelAndView index() {
		ModelAndView modelAndView = new ModelAndView();

		List<ArticleInfo> articleInfos = articleService.getAllArticle();

		modelAndView.addObject("articleInfos", articleInfos);

		modelAndView.setViewName(ARTICLE_INDEX_VIEW);
		return modelAndView;
	}

	// addArticle

	@RequestMapping(value = ARTICLE_ADD_REQUEST, method = { RequestMethod.GET })
	public ModelAndView addArtical() {
		ModelAndView modelAndView = new ModelAndView();

		modelAndView.setViewName(ADD_ARTICAL_VIEW);
		return modelAndView;
	}
///ARTICLE_ADD_REQUEST
	
	@RequestMapping(value = ARTICLE_ADD_REQUEST, method = { RequestMethod.POST })
	public ModelAndView addArtical(Model model,
			@ModelAttribute("articleInfo") ArticleInfo articleInfo,
			HttpServletRequest request) {

		UserInfo userInfo = (UserInfo) ScopeHelper.getSesionValue(request,
				"userInfo", true);
        articleInfo.setRealSavePath( (String) ScopeHelper.getSesionValue(request, "readSavePath", true));
		articleInfo.setUserId(userInfo.getId());

		articleInfo.setTitle(SimpleHelper.htmlspecialchars(articleInfo
				.getTitle()));

		articleService.addArticle(articleInfo);

		ModelAndView modelAndView = new ModelAndView();

		// modelAndView.addObject("articleInfo", articleInfo);

		modelAndView.setViewName(REDIRECT_ARTICLE_INDEX_REQUEST);

		return modelAndView;
	}

	/*
	 * Delete Article ,produces={"application/json;charset=UTF-8"}
	 */
	@RequestMapping(value = ARTICLE_DELETE_REQUEST, method = { RequestMethod.POST })
	@ResponseBody
	public JsonResponse deleteArtical(@RequestBody String deleteId,HttpServletRequest request) {

		try {
			
			ArticleInfo articleInfo = this.articleService.getArticleById(deleteId);
			String savePath = articleInfo.getRealSavePath();
			this.articleService.deleteArticle(deleteId);
			//String savePath = (String) ScopeHelper.getSesionValue(request, "readSavePath", true);
			System.out.println(savePath);
			File imgFile = new File(savePath);
			imgFile.delete();
			return new JsonResponse("ok", "ok");
			
		} catch (Exception e) {
			e.getStackTrace();
			return new JsonResponse("fail", "fail");
		}
	}
	
	
	public ModelAndView updateArticle(Model model,
			@ModelAttribute("articleInfo") ArticleInfo articleInfo,
			HttpServletRequest request){
		
		
		return null;
	}
	
	

	/*
	 * for kindeditor
	 */
	@RequestMapping(value = UPLOAD_JSON, method = { RequestMethod.POST })
	public ModelAndView uploadJson() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName(UPLOAD_JSON_VIEW);
		return modelAndView;
	}

}
