package com.pchome.Controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

//import com.microsoft.sqlserver.jdbc.StringUtils;
import com.pchome.Entity.Member;
import com.pchome.Service.LoginService;

@Controller

public class LoginController {
	
	@Autowired
	LoginService loginService;
	
	@RequestMapping(value="/user/login",method=RequestMethod.POST)
	public String loginMethod(@ModelAttribute("memberBean") Member memberBean,HttpServletRequest request
			,Map<String,Object> map) {
		HttpSession session = request.getSession();
		System.out.println(memberBean);
		Boolean xxx = loginService.checkId(memberBean.getMemberid(), memberBean.getPassword());
		
		if(xxx==true) {
			Member meminfo = loginService.getMemberinfo(memberBean.getMemberid());
			session.setAttribute("LoginOK", meminfo);
			return "redirect:/main.html";
		}else {
			map.put("msg", "用戶密碼錯誤");
			return "login";
		}
	
	}
	
	//atguigu
//	@PostMapping("/user/login")
//	public String login(@RequestParam("username") String username,
//						@RequestParam("password") String password,
//						Map<String,Object> map,HttpSession session ) {
//		session.setAttribute("LoginOK", username);
//		if(!StringUtils.isEmpty(username) && "123456".equals(password)) {
//			//登陸成功 防止表單重複提交,可以重定向到主業
//			return "redirect:/main.html";
//		}else {
//			map.put("msg", "用戶密碼錯誤");
//			return "login";
//		}
//	}
}
