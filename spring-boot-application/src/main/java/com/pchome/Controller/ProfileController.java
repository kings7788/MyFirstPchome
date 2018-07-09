package com.pchome.Controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pchome.Dao.MemberRepository;
import com.pchome.Entity.Member;
import com.pchome.Service.ProfileService;

@Controller
@RequestMapping("/membercenter")
public class ProfileController {
	@Autowired
	ProfileService profileService;
	@RequestMapping("")
	public String goProfile(Model model,HttpSession session,Map<String,Object> map) {
		Member membersession = (Member) session.getAttribute("LoginOK");
		
		map.put("memberbean", membersession);
		System.out.println(membersession);
		model.addAttribute("memberProfile",new Member());
		return "member/profile";
	}
	@RequestMapping(value="/updateMember",method=RequestMethod.POST)
	public @ResponseBody String updateProfile(@ModelAttribute("memberProfile") Member member
			,HttpSession session) {
		Member membersession = (Member) session.getAttribute("LoginOK");
		member.setMemberid(membersession.getMemberid());
		System.out.println("update method ======member==>"+member);
		profileService.updateMethod(member);
		return "success";
	}
}
