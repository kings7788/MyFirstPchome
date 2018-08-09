package com.pchome.Entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
@Embeddable
public class CompoundKey implements Serializable {
	
	@Column(name="USER_ID")
	private Long userId;
	@Column(name="ACCOUNT_ID")
	private Integer accountId;
	
	public CompoundKey() {
		super();
	}
	@Override
	public String toString() {
		return "CompoundKey [userId=" + userId + ", accountId=" + accountId + "]";
	}
	
	public CompoundKey(Long userId, Integer accountId) {
		super();
		this.userId = userId;
		this.accountId = accountId;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Integer getAccountId() {
		return accountId;
	}
	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}
	@Override
	public int hashCode() {
//		final int prime = 31;
		int result = 1;
//		result = prime * result
//				+ ((userId == null) ? 0 : userId.hashCode());
//		result = prime * result + ((accountId==null)?0:accountId.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		CompoundKey other = (CompoundKey) obj;
//		if (accountId == null) {
//			if (other.accountId != null)
//				return false;
//		} else if (!accountId.equals(other.accountId))
//			return false;
//		if (userId != other.userId)
//			return false;
		return true;
	}
	
}
