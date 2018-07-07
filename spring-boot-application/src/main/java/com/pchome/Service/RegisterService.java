package com.pchome.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pchome.Dao.MemberRepository;
import com.pchome.Entity.Member;

@Service
public class RegisterService {
	@Autowired
	MemberRepository memberRepository;
	
	
	public void registerMethod(Member memberbean) {
		Map<String, Object> ermsg = new HashMap<>();
		Map<String, Object> scmsg = new HashMap<>();
		
		Member memberList = memberRepository.findbyId(memberbean.getMemberid());
		
		System.out.println(memberList);
		
		if(memberList!=null) {
			ermsg.put("errorMsg", "帳號重複");
		}else {
		memberRepository.save(memberbean);
			scmsg.put("successMsg", "帳號申請成功");
			
		}
		
	}
}
