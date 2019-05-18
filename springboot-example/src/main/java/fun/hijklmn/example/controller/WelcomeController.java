package fun.hijklmn.example.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 * Desc: 
 * Author:GuoFusong
 * Projectname:springboot
 * Filename:WelcomeController.java
 * Tags:
 * Datetime:2019年3月20日下午6:08:56
 * Version:1.0.0
 */
@RestController
public class WelcomeController extends BaseController{

	@RequestMapping(value = "/welcome")
	public String welcome(HttpServletRequest request , HttpServletResponse response) {
		logger.info("----------------> welcome ！");
		return "welcome !";
	}
	
}
