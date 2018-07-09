package com.pchome.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pchome.Dao.MemberRepository;
import com.pchome.Entity.Member;
import com.pchome.Service.RegisterService;
@Controller
public class RegisterController {
	
	@Autowired
	RegisterService registerService;
	
	
	@RequestMapping(value = "/saveMember", method = RequestMethod.POST)
    public String saveStudent(@ModelAttribute("memberBeanreg") Member member) {
        System.out.println(member);
        registerService.registerMethod(member);
		return "index";
		// logic to process input data
    }
}
