package com.ftptest.login.service;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.ftptest.login.vo.FilmVo;
import com.ftptest.login.vo.LoginVo;
import com.ftptest.login.vo.RentalVo;
import com.ftptest.login.vo.UserVo;

@Service
public interface LoginService {

	public HashMap<String,Object> getUserId(HttpServletRequest request, LoginVo loginVo) throws Exception;
	public List<LoginVo> getUserList() throws Exception;
	
	public List<FilmVo> getFilmList(int nowIdx) throws Exception;
	public String getFilmCnt() throws Exception;
	public List<FilmVo> getFilmDetail(String filmId)throws Exception;
	public HashMap<String, Object> getLoginCheck2(UserVo userVo)throws Exception;
	public String encodeSHA256(String str) throws Exception;
	public List<RentalVo> getRentalList(RentalVo rentalVo)throws Exception;
	public String getRentalTot(RentalVo vo)throws Exception;
}
