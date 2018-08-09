package com.pchome.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.beans.factory.annotation.Autowired;

import com.pchome.Dao.AccountRepo;

@Entity
@Table(name="eemyaccount")
public class Accounts {
	
	CompoundKey compoundKey;
	@Column(name="ACCOUNT_BALANCE")
	private int accountBalance;
	
	@Transient
	private String tpPrdName;
	
	
	public String getTpPrdName() {
		return tpPrdName;
	}
	public void setTpPrdName(String tpPrdName) {
		this.tpPrdName = tpPrdName;
	}
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
	
	@Override
	public String toString() {
		return "Accounts [compoundKey=" + compoundKey + ", accountBalance=" + accountBalance + "]";
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
		
String aa = "กรุณาส่งคืนสินค้าด้วยตัวเอง (ที่อยู่ในการส่งคืนคือ ...) และขอคืนเงินหลังจากทำการยืนยัน 請自行將商品寄回(顯示退貨地址)，確認無誤後會進行退款 Please return the product by yourself (return address is ... ), and refund after confirmation";
	
	System.out.println(aa.getBytes().length);
		
		
	}
}
