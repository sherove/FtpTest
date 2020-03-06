package com.ftptest.main.controller;

import java.io.File;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class MainController {
	
	

			
	@RequestMapping("/")
	public String main() {
//		File path = new File("C:/");
//		File[] fileList = path.listFiles();
//		if(fileList.length > 0){
//		    for(int i=0; i < fileList.length; i++){
//		  		System.out.println(fileList[i]) ;
//		    }
//		}
//		
		
		
		return "/main/index";
	}

}
