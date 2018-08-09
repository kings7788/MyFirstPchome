package com.pchome.Controller;

import java.io.IOException;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pchome.Util.MailUtil;

@Controller
public class TestController {
		
		@Autowired MailUtil mail;
		@GetMapping("/testaccount")
		public String testView() {
			
			
			return "create_overseas_seller_account";
		}
		
		@GetMapping("/testmail")
		@ResponseBody
		public String testMail() throws MessagingException, IOException {
			mail.sendMail("ooo", "kings86170@gmail.com", null, "測試郵件", "<a href='https://tw.yahoo.com/'>yahoo</a>", null, null);
			
			return "mail success";
		}
}
