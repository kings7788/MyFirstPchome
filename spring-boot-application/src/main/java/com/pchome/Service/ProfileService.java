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
}
