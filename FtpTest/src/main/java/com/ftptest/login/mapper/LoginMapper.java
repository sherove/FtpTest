package com.ftptest.login.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ftptest.login.vo.FilmVo;
import com.ftptest.login.vo.LoginVo;
import com.ftptest.login.vo.RentalVo;
import com.ftptest.login.vo.UserVo;

@Mapper
public interface LoginMapper {
	
	public LoginVo loginCheck(LoginVo loginvo) throws Exception;

	public String loginCount(LoginVo loginVo) throws Exception;

	
	public List<LoginVo> getUserList()throws Exception;
	public List<FilmVo> getFilmList(FilmVo vo)throws Exception;
	
	public String  getFilmCnt()throws Exception;
	public List<FilmVo> getFilmDetail(String filmId)throws Exception;
	public String getLoginCheck2(UserVo userVo)throws Exception;

	public List<RentalVo> getRentalList(RentalVo rentalVo)throws Exception;
	public String getRentalTot(RentalVo rentalVo)throws Exception;
	
	
	
}
