package com.pchome.Entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="member2")
public class Member {
	
	@Id
	private String memberid;
	private String password;
	private String memName;
	private Integer sex;
	private Date birth;
	
	
	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public String getMemberid() {
		return memberid;
	}

	public void setMemberid(String memberid) {
		this.memberid = memberid;
	}

	public String getMemName() {
		return memName;
	}

	public void setMemName(String memName) {
		this.memName = memName;
	}
	
	

	@Override
	public String toString() {
		return "Member [memberid=" + memberid + ", password=" + password + ", memName=" + memName + ", sex=" + sex
				+ ", birth=" + birth + "]";
	}

	public Member(String memName) {
		super();
		this.memName = memName;
	
	}
	public Member() {
		super();
	}
	
}
