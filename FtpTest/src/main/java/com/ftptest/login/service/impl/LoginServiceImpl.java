package com.ftptest.login.service.impl;


import java.security.MessageDigest;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ftptest.login.mapper.LoginMapper;
import com.ftptest.login.service.LoginService;
import com.ftptest.login.vo.FilmVo;
import com.ftptest.login.vo.LoginVo;
import com.ftptest.login.vo.RentalVo;
import com.ftptest.login.vo.UserVo;
import com.spring.main.MySQLConnectionTest;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private LoginMapper loginMapper;

	@Override
	public HashMap<String, Object> getUserId(HttpServletRequest request, LoginVo loginVo) throws Exception {
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		LoginVo resultVo = loginMapper.loginCheck(loginVo);
		
//		String msg = "";
//		//예시야
//		File file = new File("예시경로");
//		if(file.exists()) {// 파일 존재 유뮤 메서드 true or false 로 값이 리턴되는 boolean 형태야 있을때지
//			file.delete();
//			msg = "삭제와ㅣㄴ료";
//		}else { //없을때지
//			msg = "d없는 파일입니다.";
//		}
		
		if(resultVo == null) {
			resultMap.put("resultMsg", "없는 아이디 입니다.");
			resultMap.put("flag", "0");
		}else {
			if(resultVo.getUserPwd().equals(loginVo.getUserPwd())){
				//비번같으면
				HttpSession session = request.getSession();
				session.setAttribute("uNo",resultVo.getUserNo() );
				session.setAttribute("uId", resultVo.getUserId() );
				session.setAttribute("uAuth", resultVo.getUserAuth() );
				resultMap.put("resultVo", resultVo);
				resultMap.put("resultMsg", "로그인성공!");
				resultMap.put("flag", "1");
			}else {
				resultMap.put("resultMsg", "비번이 다릅니다.다시 시도 해주세요.");
				resultMap.put("flag", "0");
			}
		}
		/*
		 * if (!count.equals("0")) { resultVo = loginMapper.loginCheck(loginVo);
		 * HttpSession session = request.getSession();
		 * session.setAttribute("uNo",resultVo.getUserNo() );
		 * 
		 * }
		 */
		return resultMap;
	}

	@Override
	public List<LoginVo> getUserList() throws Exception {
		List<LoginVo> list= loginMapper.getUserList();
		return list;
	}
	//필름리스트
	@Override
	public List<FilmVo> getFilmList(int nowIdx) throws Exception {
		int unitCnt = 10;
		FilmVo vo = new FilmVo();
		vo.setNowIdx(nowIdx);
		vo.setUnitCnt(unitCnt);
		List<FilmVo> list= loginMapper.getFilmList(vo);
		
		
 		return list;
	}
	//필름상세
	@Override
	public List<FilmVo> getFilmDetail(String filmId) throws Exception {
		List<FilmVo> list = loginMapper.getFilmDetail(filmId);
		return list;
	}
	//필름총카운트
	@Override
	public String getFilmCnt() throws Exception {
		return loginMapper.getFilmCnt();
	}

	//로그인체크2 두번째과제
	@Override
	public HashMap<String, Object> getLoginCheck2(UserVo userVo) throws Exception {
		String userPwd = encodeSHA256(userVo.getPassword());
		String checkPwd = encodeSHA256(loginMapper.getLoginCheck2(userVo));
		HashMap<String,Object> resultMap = new HashMap<String,Object>();
		if(userPwd.equals(checkPwd)) {
			resultMap.put("flag", 1);
			resultMap.put("msg", "로그인성공ㅎ0ㅎ 환영합니다.");
		}else {
			resultMap.put("flag", 0);
			resultMap.put("msg", "로그인실패ㅠ0ㅠ");
		}
		return resultMap;
	}
	
	//로그인체크2 렌탈getList
	@Override
	public List<RentalVo> getRentalList(RentalVo rentalVo) throws Exception {
		List<RentalVo> list = loginMapper.getRentalList(rentalVo);
		return list;
	}
	//로그인체크2 렌탈getTot
	@Override
	public String getRentalTot(RentalVo rentalVo) throws Exception {
		String tot = loginMapper.getRentalTot(rentalVo);
		return tot;
	}
	
	////////////////////////////
	@Override
	public String encodeSHA256(String str) throws Exception {
		MessageDigest md = MessageDigest.getInstance("SHA-256");
		md.update(str.getBytes()); //해시함수 계산부분
		byte[] bytes = md.digest();//byte를 배열로 return
		StringBuilder builder = new StringBuilder();
		for (byte b: bytes) {
	          builder.append(String.format("%02x", b));
	     }//for문을 돌려서 stringBuilder에 넣어서 
	    
		return builder.toString();
	}

	

	
}
