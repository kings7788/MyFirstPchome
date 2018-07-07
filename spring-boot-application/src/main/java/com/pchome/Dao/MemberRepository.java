package com.pchome.Dao;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pchome.Entity.Member;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long>{
	
	@Query("select m from Member m where m.memberid=:memberid")
	public Member findbyId(@Param("memberid") String memberid);
	
	
}