package com.pchome.Controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
	@GetMapping("")
	public String goProfile(Model model,HttpSession session,Map<String,Object> map) {
		Member membersession = (Member) session.getAttribute("LoginOK");
		map.put("memberbean", membersession);
		model.addAttribute("memberProfile",new Member());
		return "member/profile";
	}
	//修改會員資料
	@RequestMapping(value="/updateMember",method=RequestMethod.POST)
	public String updateProfile(@ModelAttribute("memberProfile") Member member
			,HttpSession session,Map<String,Object> map) {
		Member membersession = (Member) session.getAttribute("LoginOK");
		member.setMemberid(membersession.getMemberid());
		int updateCol = profileService.checkColumnfillout(member);
		System.out.println("update method ======member==>"+member + "  update  :"+updateCol+" ");
		profileService.updateMethod(member);
		map.put("memberbean", membersession);
		return "redirect:/index";
	}
}
