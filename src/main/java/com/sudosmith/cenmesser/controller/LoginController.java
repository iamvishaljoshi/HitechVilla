package com.sudosmith.cenmesser.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 
 * @author Vishal Joshi
 *
 */
@Controller
public class LoginController {

	@RequestMapping("/login")
	public String doLogin() {

		return "login";
	}

}
