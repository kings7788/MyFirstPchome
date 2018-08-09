package com.pchome.Entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="replymessage2")
public class ReplyMessage {
	@Id
	private Integer replyno;
	private Integer messageno;
	private String memberid;
	private Date postTime;
	private String replymessage;
	public Integer getReplyno() {
		return replyno;
	}
	public void setReplyno(Integer replyno) {
		this.replyno = replyno;
	}
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
	public Date getPostTime() {
		return postTime;
	}
	public void setPostTime(Date postTime) {
		this.postTime = postTime;
	}
	public String getReplymessage() {
		return replymessage;
	}
	public void setReplymessage(String replymessage) {
		this.replymessage = replymessage;
	}
	@Override
	public String toString() {
		return "ReplyMessage [replyno=" + replyno + ", messageno=" + messageno + ", memberid=" + memberid
				+ ", postTime=" + postTime + ", replymessage=" + replymessage + "]";
	}
	public ReplyMessage(Integer replyno, Integer messageno, String memberid, Date postTime, String replymessage) {
		super();
		this.replyno = replyno;
		this.messageno = messageno;
		this.memberid = memberid;
		this.postTime = postTime;
		this.replymessage = replymessage;
	}
	public ReplyMessage() {
		super();
	}

}
