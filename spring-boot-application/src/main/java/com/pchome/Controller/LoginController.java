package com.pchome.Controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pchome.Entity.Member;
import com.pchome.Service.LoginService;

@Controller
@RequestMapping("/loginService")
public class LoginController {
	
	@Autowired
	LoginService loginService;
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String loginMethod(@ModelAttribute("memberBean") Member memberBean,HttpServletRequest request
			,Map<String,Object> map) {
		HttpSession session = request.getSession();
		System.out.println(memberBean);
		Boolean xxx = loginService.checkId(memberBean.getMemberid(), memberBean.getPassword());
		
		if(xxx==true) {
			Member meminfo = loginService.getMemberinfo(memberBean.getMemberid());
			session.setAttribute("LoginOK", meminfo);
		}else {
			map.put("erMsg", "error");
			return "redirect:/login";
		}
		return "redirect:/index";
	}
}
