package com.bankmanagement.client.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@SessionAttributes({"accountNo", "firstName"})
@RequestMapping("/bankmanagement/client")
public class BankController {

	@RequestMapping("/home")
	public String home(SessionStatus sessionStatus) {
		sessionStatus.setComplete();
		return "homePage";
	}
	@RequestMapping("/Aboutus")
	public String About() {
		return "Aboutus";
	}
	@RequestMapping("/Contactus")
	public String Contact() {
		return "Contactus";
	}
	@RequestMapping("/help")
	public String Help() {
		return "help";
	}

}
