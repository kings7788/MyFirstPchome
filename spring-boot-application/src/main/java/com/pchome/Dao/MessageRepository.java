package com.pchome.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pchome.Entity.Member;
import com.pchome.Entity.Message;

@Repository
public interface MessageRepository extends JpaRepository<Message,Long>{

	@Query("select ms from Message ms where ms.messageno=:messageno")
	public Message findbyId(@Param("messageno") Integer messageno);
}
