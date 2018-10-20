package com.pchome.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdController {
	
	@GetMapping("/webindex")
	public String webIndex() {
		return "webindex";
	}
}
