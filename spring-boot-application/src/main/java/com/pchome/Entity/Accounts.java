package com.pchome.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;

import com.pchome.Dao.AccountRepo;

@Entity
@Table(name="account")
public class Accounts {
	
	CompoundKey compoundKey;
	
	private int accountBalance;
	
	@Id
	public CompoundKey getCompoundKey() {
		return compoundKey;
	}
	public void setCompoundKey(CompoundKey compoundKey) {
		this.compoundKey = compoundKey;
	}
	public int getAccountBalance() {
		return accountBalance;
	}
	public void setAccountBalance(int accountBalance) {
		this.accountBalance = accountBalance;
	}
	
	public Accounts(CompoundKey compoundKey, int accountBalance) {
		super();
		this.compoundKey = compoundKey;
		this.accountBalance = accountBalance;
	}
	
	public Accounts() {
		super();
	}
	public static void main(String[] args) {
		
		
		
		
		
		
	}
}
