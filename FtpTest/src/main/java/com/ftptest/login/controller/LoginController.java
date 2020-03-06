package com.ftptest.login.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ftptest.login.service.LoginService;
import com.ftptest.login.vo.FilmVo;
import com.ftptest.login.vo.LoginVo;
import com.ftptest.login.vo.RentalVo;
import com.ftptest.login.vo.UserVo;

@Controller
@RequestMapping("/login")
public class LoginController {
	
	@Autowired
	private LoginService loginService;
	
	/**
	 * 로그인
	 * @param loginVo
	 * @param request
	 */
	@RequestMapping("/loginCheck")
	@ResponseBody
	public HashMap<String,Object> loginCheck(@ModelAttribute("loginVo") LoginVo loginVo,HttpServletRequest request) throws Exception{
		HashMap<String,Object> resultMap = loginService.getUserId(request, loginVo);
		System.out.println(resultMap);
		return resultMap;
	}
	
	/**
	 * 로그인페이지(두번째과제)
	 * @param request
	 * @throws Exception
	 */
	@RequestMapping("/loginPage")
	public String loginPage(HttpServletRequest request) throws Exception{
		return "/login/loginPage";
	}
	
	/**
	 * 로그인체크(두번째과제)
	 * @param loginVo
	 * @param request
	 */
	@RequestMapping("/loginCheck2")
	@ResponseBody
	public HashMap<String,Object> loginCheck2(@ModelAttribute("userVo") UserVo userVo,HttpServletRequest request) throws Exception{
		HashMap<String, Object> resultMap= loginService.getLoginCheck2(userVo);
		System.out.println(resultMap);
		return resultMap;
	}
	/**
	 * 로그인메인(두번째과제)
	 * @param loginVo
	 * @param request
	 */
	@RequestMapping("/rentalMain")
	public String loginMain(@ModelAttribute("userVo") UserVo userVo,HttpServletRequest request) throws Exception{
		return "/rental/rentalMain";
	}
	/**
	 * 렌탈리스트
	 * @param request
	 * @return 
	 */
	@RequestMapping("/rentalList")
	@ResponseBody
	public HashMap<String,Object> rentalList(HttpServletRequest request,RentalVo vo) throws Exception{

		//페이지단위 unit10설정
		vo.setUnitCnt(10);
		int idx = (vo.getNowIdx()-1);
		
		if(idx!=0) {
			idx = idx*10; //10,20,30 nowIdx 여기서 설정해줌
		}
		
		//페이지단위 nowIdx설정
		vo.setNowIdx(idx);
		HashMap<String,Object> resultMap = new HashMap<String,Object>();
		List<RentalVo> list = loginService.getRentalList(vo);
		String totcnt = loginService.getRentalTot(vo);
		resultMap.put("list", list);
		resultMap.put("totcnt", totcnt);
		
		return resultMap;
	}
	
	/**
	 * 파일삭제
	 * @param loginVo
	 * @throws Exception
	 */
	@RequestMapping("/loginChk")
	@ResponseBody
	public HashMap<String,Object> loginChk(@ModelAttribute("loginVo") LoginVo loginVo,HttpServletRequest request) throws Exception{
		HashMap<String,Object> resultMap = loginService.getUserId(request, loginVo);
		System.out.println(resultMap);
		return resultMap;
	}
	
	
	
	/**
	 * 파일삭제
	 * @param loginVo
	 * @param request
	 * @return
	 * @throws Exception
	 */
	
	@RequestMapping("/deleteFile")
	@ResponseBody
	public HashMap<String,Object> deleteFile(@ModelAttribute("loginVo") LoginVo loginVo,HttpServletRequest request) throws Exception{
		HashMap<String,Object> resultMap = loginService.getUserId(request, loginVo);
		System.out.println(resultMap);
		return resultMap;
	}
	
	
	
	/**
	 * 파일업로드
	 * @param mre
	 * @param request
	 * @param model
	 * @param flash
	 * @return
	 * @throws Exception
	 */
	
	@RequestMapping("/uploadFile")
	@ResponseBody
	public String uploadFile(MultipartHttpServletRequest mre, HttpServletRequest request, Model model, RedirectAttributes flash)throws Exception{
		String testNm = request.getParameter("testName");
		MultipartFile mf1 = mre.getFile("fileOb1");
		MultipartFile mf2 = mre.getFile("fileOb2");
		String uploadPath = "";
		String msg = "";
		
		String or1 = mf1.getOriginalFilename();
		int pos = or1.lastIndexOf(".");
		String ext = or1.substring(pos+1);
		
		String fileNm1 = UUID.randomUUID().toString()+"_"+System.currentTimeMillis()+"."+ext;
		//String upload22 = path+fileNm1;
		System.out.println("파일이름 : "+or1);
		System.out.println("숫자  : "+pos);
		System.out.println("substring결과 : "+ext);
		System.out.println("fileNm1 " + fileNm1);
		
		String path =  "C:/upload/";
		String uploadPath1 =path+or1; 
		try {
			mf1.transferTo(new File(uploadPath1));
			msg = "s";
		}	catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			msg = "f";
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			msg = "f";
			e.printStackTrace();
		}
		
		

		return msg;
	}
	/**
	 * 유저리스트불러오기
	 * @throws Exception
	 */
	@RequestMapping("/userList")
	public String userList(Model model, RedirectAttributes flash)  throws Exception{
		model.addAttribute("list",(loginService.getUserList()));
		return "/login/userList";
	}
	/**
	 * 필름리스트불러오기
	 * @throws Exception
	 */
	@RequestMapping("/filmList")
	public String filmList(HttpServletRequest request, Model model,RedirectAttributes flash)  throws Exception{
		int nowIdx = 0;
		System.out.println("ㄴㄴㄴ"+loginService.getFilmCnt());//총카운트
		model.addAttribute("totCnt", loginService.getFilmCnt());
		model.addAttribute("list",loginService.getFilmList(nowIdx));
		return "/login/filmList";
	}
	/**
	 * 필름페이지 10개씩
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping("/filmPage")
	public List<FilmVo> filmPage(HttpServletRequest request, Model model ,FilmVo vo ,RedirectAttributes flash)  throws Exception{
		/*
		 * request.getAttribute("nowIdx"); System.out.println("히히히 " +
		 * request.getAttribute("nowIdx")); System.out.println("히히히22 " + vo);
		 */
		int nowIdx = vo.getNowIdx();
		if(nowIdx == 1) {
			nowIdx = 0;
		}else {
			nowIdx = (nowIdx-1)*10;
		}
		System.out.println(loginService.getFilmList(nowIdx));
		List<FilmVo> list = loginService.getFilmList(nowIdx);
		return list;
	}
	
	/**
	 * 필름상세불러오기 AJAX 
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping("/filmDetail")
	public List<FilmVo> filmDetail(HttpServletRequest request,Model model, RedirectAttributes flash)  throws Exception{
		System.out.println("머냐머냐 : " + request.getParameter("filmId"));
		String filmId = request.getParameter("filmId");
		model.addAttribute("actorList",loginService.getFilmDetail(filmId));
		List<FilmVo> list = loginService.getFilmDetail(filmId);
		return list;
	}
	
	
	
	/**
	 * 관리자페이지
	 * @param model
	 * @param flash
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/adminPage")
	public String adminPage(Model model, RedirectAttributes flash)  throws Exception{
		File path = new File("C:/upload/");
		List<File> list = new ArrayList<File>();
		List<String> listType = new ArrayList<String>();
		File[] fileList = path.listFiles();
		if(fileList.length > 0){
		    for(int i=0; i < fileList.length; i++){
		  		list.add(fileList[i]);
		    }
		}
		List<HashMap<String, Object>> folderList = new ArrayList<HashMap<String,Object>>();
		List<HashMap<String, Object>> fileList2 = new ArrayList<HashMap<String,Object>>();
		HashMap<String, Object> fileInfo = new HashMap<String, Object>();
		if(fileList.length > 0){
		    for(int i=0; i < fileList.length; i++){

		    	Path source = Paths.get(fileList[i].toString());
		    	String mimeType2 = Files.probeContentType(source);
		    	

		    	list.add(fileList[i]);
		    	

		    	
		  		if("null".equals(mimeType2) || null==mimeType2) {
		  			if(fileList[i].isDirectory()) {
		  				listType.add("f");

		  			}else if(fileList[i].isFile()) {
		  				listType.add("n");

		  			}
		  			
		    	}else if("text/html".equals(mimeType2)){
		    		listType.add("c");
		    	}else if("text/plain".equals(mimeType2)){
		    		listType.add("t");
		    	}
		    }
		}

		model.addAttribute("listType",listType);
		model.addAttribute("list",list);
		
		return "/login/adminPage";
	}
	/**
	 * 사용자페이지
	 * @param model
	 * @param flash
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/userPage")
	public String userPage(Model model, RedirectAttributes flash)  throws Exception{
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		File path = new File("C:/upload/");
		List<File> list = new ArrayList<File>();
		List<File> listFolder = new ArrayList<File>();
		List<String> listType = new ArrayList<String>();
		File[] fileList = path.listFiles();
	
		
		
		if(fileList.length > 0){
		    for(int i=0; i < fileList.length; i++){
	    	
		    	Path source = Paths.get(fileList[i].toString());
		    	String mimeType2 = Files.probeContentType(source);

		   
		    	if(fileList[i].isDirectory()) {
		    		listFolder.add(fileList[i]);
		    	}else {
		    		if("null".equals(mimeType2) || null==mimeType2) {
			  			if(fileList[i].isFile()) {
			  				listType.add("n");
			  			}
			    	}else if("text/html".equals(mimeType2)){
			    		listType.add("c");
			    		
			    	}else if("text/plain".equals(mimeType2)){
			    		listType.add("t");
			    	}else if("application/x-zip-compressed".contentEquals(mimeType2)) {
			    		listType.add("z");
			    	}else if("image/png".contentEquals(mimeType2)){
			    		listType.add("p");
			    	}else {
			    		listType.add("n");
			    	}
		    		list.add(fileList[i]);
		    	}
		    }
		}

		resultMap.put("list", list);
		resultMap.put("listType", listType);
		
		model.addAttribute("listType",listType);
		model.addAttribute("list",list);
		model.addAttribute("list2",listFolder);
		model.addAttribute("resultMap",resultMap);
		return "/login/userPage";
	}
	
}
