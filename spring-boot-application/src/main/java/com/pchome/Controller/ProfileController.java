package com.pchome.Controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pchome.Dao.MemberRepository;
import com.pchome.Entity.Member;

@Controller
@RequestMapping("/membercenter")
public class ProfileController {
	@Autowired
	MemberRepository memberrepository;
	@RequestMapping("")
	public String goProfile(HttpSession session,Map<String,Object> map) {
		Member membersession = (Member) session.getAttribute("LoginOK");
		Member member = memberrepository.findbyId(membersession.getMemberid());
		map.put("memberbean", membersession);
		return "member/profile";
	}
}
