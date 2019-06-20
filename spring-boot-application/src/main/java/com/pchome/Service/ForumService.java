package com.pchome.Service;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pchome.Dao.MessageRepository;
import com.pchome.Entity.Message;

@Service
public class ForumService {
	
	@Autowired
	MessageRepository messageRepository;
	
	public List<Message> findAllMessage(){
		List<Message> messagelist = messageRepository.findAll();
		return messagelist;
	}
	
	public int addMessage(Message message) {
		List<Message> messagelist = messageRepository.findAll();
		int size = messagelist.size();
		int newsize = size + 1;
		message.setMessageno(newsize);
		message.setBeclicked(0);
		java.util.Date date = new java.util.Date();
		long t = date.getTime();
		java.sql.Timestamp sqlTimestamp = new java.sql.Timestamp(t);
		message.setPostTime(sqlTimestamp);
		System.out.println(message);
		messageRepository.save(message);
		return 1;	
	}
	
	public Message linkMessage(String messageid) {
		Message message= messageRepository.findbyId(Integer.valueOf(messageid));
		return message;
	}
}
