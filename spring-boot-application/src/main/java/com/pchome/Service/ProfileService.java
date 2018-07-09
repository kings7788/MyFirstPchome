package com.pchome.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pchome.Dao.MemberRepository;
import com.pchome.Entity.Member;

@Service
public class ProfileService {
	@Autowired
	MemberRepository memberRepository;
	
	public Member updateMethod(Member memberbean) {
		Member memberState = memberRepository.save(memberbean);
		return memberState;
	}
	
	public int checkColumnfillout(Member memberbean) {
		int updatecount = 4; 	
		System.out.println("check method  -------------" + memberbean);
		if(memberbean!=null&&memberbean.getMemberid()!=null) {
			
			Member originalprofile = memberRepository.findbyId(memberbean.getMemberid());
			if(memberbean.getMemName()==""||memberbean.getMemName()==null) {
				memberbean.setMemName(originalprofile.getMemName());
				updatecount--;
			}
			if(memberbean.getPassword()==""||memberbean.getPassword()==null) {
				memberbean.setPassword(originalprofile.getPassword());
				updatecount--;
			}
			if(memberbean.getSex()==null) {
				memberbean.setSex(originalprofile.getSex());
				updatecount--;
			}
			if(memberbean.getBirth()==null) {
				memberbean.setBirth(originalprofile.getBirth());
				updatecount--;
			}
		}
		
		return updatecount;
		
	
	}
}
