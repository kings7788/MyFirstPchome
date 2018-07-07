package com.pchome.Service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pchome.Dao.ReplyMessageRepository;
import com.pchome.Entity.ReplyMessage;



@Service
public class ReplyService {
	 
	@Autowired
	ReplyMessageRepository replyrepository;
	
	public ReplyMessage addReplyMsg(String replyMsg,String memberid,Integer messageno) {
		List<ReplyMessage> list = replyrepository.findAll();
		int size = list.size();
		int newsize = size+1;
		java.util.Date date = new java.util.Date();
		long t = date.getTime();
		java.sql.Timestamp sqlTimestamp = new java.sql.Timestamp(t);
		ReplyMessage replyMessage = new ReplyMessage(newsize, messageno, memberid, sqlTimestamp, replyMsg);
		replyrepository.save(replyMessage);
		return replyMessage;
	}
	
	public List<ReplyMessage> findbyMessageNo(Integer messageNo){
		return replyrepository.findbyMessageno(messageNo);
		
	}
}
