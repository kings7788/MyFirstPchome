package com.pchome.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pchome.Dao.MemberRepository;
import com.pchome.Entity.Member;

@Service
public class LoginService {
	@Autowired
	MemberRepository memberRepository;

	public Boolean checkId(String memberid,String password) {
		Boolean Id = null;
		Member member = memberRepository.findbyId(memberid);
			System.out.println(member);
			if(member!=null) {
				System.out.println("有這個帳號");
				if(password.equals(member.getPassword())) {
					Id = true;					
				}else{
					System.out.println("密碼不正確");
					Id=false;
				};
			}else {
				System.out.println("沒有這個帳號");
				Id = false;
			}
		return Id;
	}
	
	public Member getMemberinfo(String memberid) {
		Member member = memberRepository.findbyId(memberid);
		return member;
	}
	
	
	
	
	
	
}
