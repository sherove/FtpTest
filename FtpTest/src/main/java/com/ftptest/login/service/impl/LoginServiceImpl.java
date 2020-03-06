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
//		//���þ�
//		File file = new File("���ð��");
//		if(file.exists()) {// ���� ���� ���� �޼��� true or false �� ���� ���ϵǴ� boolean ���¾� ��������
//			file.delete();
//			msg = "�����ͤӤ���";
//		}else { //��������
//			msg = "d���� �����Դϴ�.";
//		}
		
		if(resultVo == null) {
			resultMap.put("resultMsg", "���� ���̵� �Դϴ�.");
			resultMap.put("flag", "0");
		}else {
			if(resultVo.getUserPwd().equals(loginVo.getUserPwd())){
				//���������
				HttpSession session = request.getSession();
				session.setAttribute("uNo",resultVo.getUserNo() );
				session.setAttribute("uId", resultVo.getUserId() );
				session.setAttribute("uAuth", resultVo.getUserAuth() );
				resultMap.put("resultVo", resultVo);
				resultMap.put("resultMsg", "�α��μ���!");
				resultMap.put("flag", "1");
			}else {
				resultMap.put("resultMsg", "����� �ٸ��ϴ�.�ٽ� �õ� ���ּ���.");
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
	//�ʸ�����Ʈ
	@Override
	public List<FilmVo> getFilmList(int nowIdx) throws Exception {
		int unitCnt = 10;
		FilmVo vo = new FilmVo();
		vo.setNowIdx(nowIdx);
		vo.setUnitCnt(unitCnt);
		List<FilmVo> list= loginMapper.getFilmList(vo);
		
		
 		return list;
	}
	//�ʸ���
	@Override
	public List<FilmVo> getFilmDetail(String filmId) throws Exception {
		List<FilmVo> list = loginMapper.getFilmDetail(filmId);
		return list;
	}
	//�ʸ���ī��Ʈ
	@Override
	public String getFilmCnt() throws Exception {
		return loginMapper.getFilmCnt();
	}

	//�α���üũ2 �ι�°����
	@Override
	public HashMap<String, Object> getLoginCheck2(UserVo userVo) throws Exception {
		String userPwd = encodeSHA256(userVo.getPassword());
		String checkPwd = encodeSHA256(loginMapper.getLoginCheck2(userVo));
		HashMap<String,Object> resultMap = new HashMap<String,Object>();
		if(userPwd.equals(checkPwd)) {
			resultMap.put("flag", 1);
			resultMap.put("msg", "�α��μ�����0�� ȯ���մϴ�.");
		}else {
			resultMap.put("flag", 0);
			resultMap.put("msg", "�α��ν��Ф�0��");
		}
		return resultMap;
	}
	
	//�α���üũ2 ��ŻgetList
	@Override
	public List<RentalVo> getRentalList(RentalVo rentalVo) throws Exception {
		List<RentalVo> list = loginMapper.getRentalList(rentalVo);
		return list;
	}
	//�α���üũ2 ��ŻgetTot
	@Override
	public String getRentalTot(RentalVo rentalVo) throws Exception {
		String tot = loginMapper.getRentalTot(rentalVo);
		return tot;
	}
	
	////////////////////////////
	@Override
	public String encodeSHA256(String str) throws Exception {
		MessageDigest md = MessageDigest.getInstance("SHA-256");
		md.update(str.getBytes()); //�ؽ��Լ� ���κ�
		byte[] bytes = md.digest();//byte�� �迭�� return
		StringBuilder builder = new StringBuilder();
		for (byte b: bytes) {
	          builder.append(String.format("%02x", b));
	     }//for���� ������ stringBuilder�� �־ 
	    
		return builder.toString();
	}

	

	
}
