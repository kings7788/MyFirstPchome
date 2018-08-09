package com.pchome.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.pchome.Dao.AccountRepo;
import com.pchome.Entity.Accounts;
import com.pchome.Entity.CompoundKey;

@Controller
public class AccountController {
	@Autowired 
	AccountRepo accountrepo;
	
	@GetMapping("/compoundkey")
	public void dosomething() {
	CompoundKey key1 = new CompoundKey(200L, 1001);
	Accounts savings = new Accounts();
	savings.setCompoundKey(key1);
	savings.setAccountBalance(8500);
//	CompoundKey key2 = new CompoundKey("100", "22001");
//	Accounts checking = new Accounts();
//	checking.setCompoundKey(key2);
//	checking.setAccountBalance(2500);
	accountrepo.save(savings);
	System.out.println(accountrepo.findAll());
	
//	accountrepo.save(checking);
	}

	@GetMapping("/compoundkey2")
	public void dosomething2() {
	CompoundKey key1 = new CompoundKey(202L, 1001);
	Accounts savings = new Accounts();
	savings.setCompoundKey(key1);
	savings.setAccountBalance(8500);
//	CompoundKey key2 = new CompoundKey("100", "22001");
//	Accounts checking = new Accounts();
//	checking.setCompoundKey(key2);
//	checking.setAccountBalance(2500);
	accountrepo.save(savings);
//	accountrepo.save(checking);
	}
}
