package com.pchome.Entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="message2")
public class Message {
	@Id
	private Integer messageno;
	private String memberid;
	private String title;
	private Date postTime;
	private Integer beclicked;
	private String mymessage;

	public Integer getMessageno() {
		return messageno;
	}
	public void setMessageno(Integer messageno) {
		this.messageno = messageno;
	}
	public String getMemberid() {
		return memberid;
	}
	public void setMemberid(String memberid) {
		this.memberid = memberid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Date getPostTime() {
		return postTime;
	}
	public void setPostTime(Date postTime) {
		this.postTime = postTime;
	}
	
	public String getMymessage() {
		return mymessage;
	}
	public void setMymessage(String mymessage) {
		this.mymessage = mymessage;
	}
	public Integer getBeclicked() {
		return beclicked;
	}
	public void setBeclicked(Integer beclicked) {
		this.beclicked = beclicked;
	}
	public Message(Integer messageno, String memberid, String title, Date postTime, Integer beclicked, String mymessage) {
		super();
		this.messageno = messageno;
		this.memberid = memberid;
		this.title = title;
		this.postTime = postTime;
		this.beclicked = beclicked;
		this.mymessage = mymessage;
	}
	public Message() {
		super();
	}
	@Override
	public String toString() {
		return "Message [messageno=" + messageno + ", memberid=" + memberid + ", title=" + title + ", postTime="
				+ postTime + ", beclicked=" + beclicked + ", mymessage=" + mymessage + "]";
	}
	
	
	

	
}
