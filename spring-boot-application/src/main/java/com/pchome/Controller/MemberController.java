package com.pchome.Controller;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.pchome.Dao.MemberRepository;
import com.pchome.Entity.Member;

@Controller
public class MemberController {
	@Autowired
	MemberRepository memberRepository;
	
	//查詢所有會員返回列表頁面
	@GetMapping("/members")
	public String list(Model model) {
		
		List<Member> members = memberRepository.findAll();
		
		//放在請求域中
		model.addAttribute("members",members);

		//thymeleaf默認會拚串
		//classpath:/templates/xxx.html
		return "member/list";
	}
	
}
