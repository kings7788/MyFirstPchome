package com.pchome.Controller;

import java.io.IOException;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pchome.Util.Base64ImgUtil;
import com.pchome.Util.MailUtil;


@Controller
public class TestController {
		
		@Autowired MailUtil mail;
		@GetMapping("/testaccount")
		public String testView() {
			
			
			return "createSellerTaiwan";
		}
		
		@GetMapping("/testmail")
		@ResponseBody
		public String testMail(Model model) throws MessagingException, IOException {
			mail.sendMail("ooo", "kings86170@gmail.com", null, "測試郵件", "<a href='https://tw.yahoo.com/'>yahoo</a>", null, null);
			model.addAttribute("", "");
			model.addAttribute("abc", "def");
			return "mail success";
		}
		@Autowired Base64ImgUtil imgUtil;
		
		@PostMapping(value="/testing")
		@ResponseBody
		public String testController(
				@RequestParam(value="base64code", required=false) String base64code
				) {
		//	LogUtil.log.warn("...test base64code "+ base64code);
			System.out.println("...test base64code "+ base64code);
			
			imgUtil.convertBase64ToFile(base64code, "/Users/boen/Desktop/test.jpg");
			
			
			return "success";
		}
}
