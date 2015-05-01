package com.simple.reading.admin.controllers;

import java.io.File;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.simple.reading.admin.form.model.ArticleInfo;
import com.simple.reading.admin.form.model.PicInfo;
import com.simple.reading.admin.form.model.UserInfo;
import com.simple.reading.admin.services.ArticleService;
import com.simple.reading.admin.services.PicService;
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

	private final static String ARTICLE_UPDATE_REQUEST = CONTROLLER
			+ "/updateartical";

	private final static String UPLOAD_JSON = CONTROLLER + "/uploadJson";

	// Redirect
	private final static String REDIRECT = "redirect:";

	private final static String REDIRECT_ARTICLE_INDEX_REQUEST = REDIRECT
			+ ARTICLE_INDEX_REQUEST;

	// view path
	private final static String ARTICLE_INDEX_VIEW = "manageartical/artical-index";

	private final static String ADD_ARTICAL_VIEW = "manageartical/artical-add";

	private final static String UPDATE_ARTICAL_VIEW = "manageartical/artical-update";

	private final static String UPLOAD_JSON_VIEW = "upload_json";

	// *************************************************************************
	@Autowired
	private ArticleService articleService;

	@Autowired
	private PicService picService;

	public ArticleService getArticleService() {
		return articleService;
	}

	public void setArticleService(ArticleService articleService) {
		this.articleService = articleService;
	}

	public PicService getPicService() {
		return picService;
	}

	public void setPicService(PicService picService) {
		this.picService = picService;
	}

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
		ArticleInfo articleInfo = new ArticleInfo();

		modelAndView.addObject("articleInfo", articleInfo);

		modelAndView.setViewName(ADD_ARTICAL_VIEW);
		return modelAndView;
	}

	// /ARTICLE_ADD_REQUEST

	@RequestMapping(value = ARTICLE_ADD_REQUEST, method = { RequestMethod.POST })
	public ModelAndView addArtical(Model model,
			@ModelAttribute("articleInfo") ArticleInfo articleInfo,
			HttpServletRequest request) {

		UserInfo userInfo = (UserInfo) ScopeHelper.getSesionValue(request,
				"userInfo", true);
		articleInfo.setUserId(userInfo.getId());

		articleInfo.setTitle(SimpleHelper.htmlspecialchars(articleInfo
				.getTitle()));

		articleService.addArticle(articleInfo);

		this.updatePicDb(articleInfo.getId(), articleInfo.getContent());

		ModelAndView modelAndView = new ModelAndView();

		// modelAndView.addObject("articleInfo", articleInfo);

		modelAndView.setViewName(REDIRECT_ARTICLE_INDEX_REQUEST);

		return modelAndView;
	}

	private void updatePicDb(String articleId, String content) {
		List<PicInfo> PicInfos = this.picService.getPicByArticleId(articleId);

		for (PicInfo picInfo : PicInfos) {
			if (content.contains(picInfo.getUrl())) {
				picInfo.setAvailable(true);

			} else {
				picInfo.setAvailable(false);
			}
			this.picService.updatePicByUrl(picInfo);
		}
	}

	/*
	 * Delete Article ,produces={"application/json;charset=UTF-8"}
	 */
	@RequestMapping(value = ARTICLE_DELETE_REQUEST, method = { RequestMethod.POST })
	@ResponseBody
	public JsonResponse deleteArtical(@RequestBody String deleteId,
			HttpServletRequest request) {

		try {

			ArticleInfo articleInfo = this.articleService
					.getArticleById(deleteId);

			this.articleService.deleteArticle(deleteId);

			return new JsonResponse("ok", "ok");

		} catch (Exception e) {
			e.getStackTrace();
			return new JsonResponse("fail", "fail");
		}
	}

	@RequestMapping(value = ARTICLE_UPDATE_REQUEST, method = { RequestMethod.GET })
	public String updateArticle(Model model, String id,
			HttpServletRequest request) {

		ArticleInfo articleInfo = this.articleService.getArticleById(id);
		model.addAttribute(articleInfo);
		return UPDATE_ARTICAL_VIEW;

	}

	@RequestMapping(value = ARTICLE_UPDATE_REQUEST, method = { RequestMethod.POST })
	public String updateArticle(Model model,
			@ModelAttribute("articleInfo") ArticleInfo articleInfo,
			HttpServletRequest request) {

		String requestId = articleInfo.getId();
		ArticleInfo article = this.articleService.getArticleById(requestId);

		article.setTitle(articleInfo.getTitle());
		article.setContent(articleInfo.getContent());
		article.setChangeDate(new Date());

		this.articleService.updateArticleById(article);

		this.updatePicDb(articleInfo.getId(), articleInfo.getContent());

		model.addAttribute(articleInfo);
		// return UPDATE_ARTICAL_VIEW;

		return REDIRECT_ARTICLE_INDEX_REQUEST;

	}

	/*
	 * for kindeditor
	 */
	@RequestMapping(value = UPLOAD_JSON, method = { RequestMethod.POST })
	@ResponseBody
	public void uploadJson(HttpServletRequest request,
			HttpServletResponse response, PrintWriter out, String id) {
		/**
		 * KindEditor JSP
		 * 
		 * 本JSP程序是演示程序，建议不要直接在实际项目中使用。 如果您确定直接使用本程序，使用之前请仔细确认相关安全设置。
		 * 
		 */
		System.out.println("id==============>" + id);
		// String articleId = request.getParameter("id");
		// System.out.println("id==============>"+id);
		// 文件保存目录路径
		// String savePath = pageContext.getServletContext().getRealPath("/") +
		// "WEB-INF/attached/";

		String savePath = request.getSession().getServletContext()
				.getRealPath("WEB-INF/attached")
				+ "\\";

		// 文件保存目录URL
		String saveUrl = request.getContextPath() + "/attached/";

		// 定义允许上传的文件扩展名
		HashMap<String, String> extMap = new HashMap<String, String>();
		extMap.put("image", "gif,jpg,jpeg,png,bmp");
		extMap.put("flash", "swf,flv");
		extMap.put("media", "swf,flv,mp3,wav,wma,wmv,mid,avi,mpg,asf,rm,rmvb");
		extMap.put("file", "doc,docx,xls,xlsx,ppt,htm,html,txt,zip,rar,gz,bz2");

		// 最大文件大小
		long maxSize = 1000000;

		response.setContentType("text/html; charset=UTF-8");

		if (!ServletFileUpload.isMultipartContent(request)) {
			out.println(getError("请选择文件。"));
		}
		// 检查目录
		File uploadDir = new File(savePath);
		if (!uploadDir.isDirectory()) {
			out.println(getError("上传目录不存在。"));
		}
		// 检查目录写权限
		if (!uploadDir.canWrite()) {
			out.println(getError("上传目录没有写权限。"));
		}

		String dirName = request.getParameter("dir");
		if (dirName == null) {
			dirName = "image";
		}
		if (!extMap.containsKey(dirName)) {
			out.println(getError("目录名不正确。"));
		}
		// 创建文件夹
		savePath += dirName + "/";
		saveUrl += dirName + "/";
		File saveDirFile = new File(savePath);
		if (!saveDirFile.exists()) {
			saveDirFile.mkdirs();
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String ymd = sdf.format(new Date());
		savePath += ymd + "/";
		saveUrl += ymd + "/";
		File dirFile = new File(savePath);
		if (!dirFile.exists()) {
			dirFile.mkdirs();
		}

		FileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		upload.setHeaderEncoding("UTF-8");
		List items = null;
		try {
			items = upload.parseRequest(request);
		} catch (FileUploadException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			System.out.println("upload error!!!!!!!!!!");
		}
		Iterator itr = items.iterator();
		while (itr.hasNext()) {
			FileItem item = (FileItem) itr.next();
			String fileName = item.getName();
			long fileSize = item.getSize();
			if (!item.isFormField()) {
				// 检查文件大小
				if (item.getSize() > maxSize) {
					out.println(getError("上传文件大小超过限制。"));
				}
				// 检查扩展名
				String fileExt = fileName.substring(
						fileName.lastIndexOf(".") + 1).toLowerCase();
				if (!Arrays.<String> asList(extMap.get(dirName).split(","))
						.contains(fileExt)) {
					out.println(getError("上传文件扩展名是不允许的扩展名。\n只允许"
							+ extMap.get(dirName) + "格式。"));
				}

				SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
				String newFileName = df.format(new Date()) + "_"
						+ new Random().nextInt(1000) + "." + fileExt;

				PicInfo picInfo = this.createPicInfo(savePath, saveUrl,
						newFileName);
				picInfo.setArticleId(id);
				picService.addPic(picInfo);
				try {
					File uploadedFile = new File(savePath, newFileName);
					item.write(uploadedFile);

				} catch (Exception e) {
					out.println(getError("上传文件失败。"));
				}

				JSONObject obj = new JSONObject();
				obj.put("error", 0);
				obj.put("url", saveUrl + newFileName);
				out.println(obj.toJSONString());
			}
		}
		// ModelAndView modelAndView = new ModelAndView();
		// modelAndView.setViewName(UPLOAD_JSON_VIEW);
		out.println("succeed");
	}

	private PicInfo createPicInfo(String savePath, String saveUrl,
			String newFileName) {

		PicInfo picInfo = new PicInfo();

		String savePathfull = savePath + newFileName;

		String saveUrlfull = saveUrl + newFileName;

		picInfo.setSavePath(savePathfull);

		picInfo.setUrl(saveUrlfull);

		picInfo.setAvailable(false);

		return picInfo;
	}

	private String getError(String message) {
		JSONObject obj = new JSONObject();
		obj.put("error", 1);
		obj.put("message", message);
		return obj.toJSONString();
	}

}
