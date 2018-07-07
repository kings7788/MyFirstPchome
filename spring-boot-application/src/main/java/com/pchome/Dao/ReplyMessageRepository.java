package com.pchome.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pchome.Entity.ReplyMessage;


@Repository
public interface ReplyMessageRepository extends JpaRepository<ReplyMessage,Long>{

	@Query("select rm from ReplyMessage rm where rm.messageno=:messageno")
	public List<ReplyMessage> findbyMessageno(@Param("messageno") Integer mesageno);
	

}


