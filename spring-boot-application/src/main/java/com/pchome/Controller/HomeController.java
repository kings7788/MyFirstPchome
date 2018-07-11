package com.pchome.Controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pchome.Entity.Member;
import com.pchome.Entity.Message;
import com.pchome.Service.ForumService;

@Controller
public class HomeController {
	
	@Autowired
	ForumService forumService;
	
	@RequestMapping({"/","/index"})
	public String homepage(HttpSession session,Map<String,Object> map) {
		Member membersession = (Member) session.getAttribute("LoginOK");
		map.put("memberbean", membersession);
		System.out.println("=============="+membersession);
		return "index";
	}
	
	@RequestMapping("/register")
	public String register(Model model) {
		Member member = new Member();
		model.addAttribute("memberBeanreg", member);
		return "register";
	}
	@RequestMapping("/login")
	public String login(Model model) {
		Member member = new Member();
		model.addAttribute("memberBean", member);
		return "login";
	}
	@RequestMapping("/forum")
	public String forum(Map<String,Object> map,Model model,HttpSession session) {
		List<Message> messagelist = forumService.findAllMessage();
		Member membersession = (Member) session.getAttribute("LoginOK");
		Message message = new Message();
		model.addAttribute("messageform",message);
		map.put("memberbean", membersession);
		map.put("messagelist",messagelist);
		return "forum/forumIndex";
	}
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("LoginOK");
		return "redirect:/index";
	}
}
