package com.pchome;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.pchome.Dao.MemberRepository;
import com.pchome.Entity.Member;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {
	@Autowired
	MemberRepository memberrepository;
	@Test
	public void contextLoads() {
		List<Member> list  = memberrepository.findAll();
		System.out.println(list);
	}

}
