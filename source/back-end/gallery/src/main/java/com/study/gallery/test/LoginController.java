package com.study.gallery.test;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping("/login/v1")
public class LoginController {

	@GetMapping("duplicatecheck")
	public String duplicateCheck(@RequestParam String id) {
		
		if(id.equals("seejinjja"))
			return "duplicate";
		else
			return "available";
	}

}
