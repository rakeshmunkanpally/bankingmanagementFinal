package com.bankmanagement.client.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bankmanagement.client.URLs;
import com.bankmanagement.client.payloads.ApiResponse;
import com.bankmanagement.client.payloads.Login;
import com.bankmanagement.client.payloads.UserDto;

import jakarta.validation.Valid;

@Controller
@SessionAttributes("admin")
@RequestMapping("/bankmanagement/client/admin")
public class AdminController {

	
	@Autowired
	RestTemplate restTemplate;
	@RequestMapping(path = "/login")
	public String adminLogin(Model model) {
		model.addAttribute("adminLogin", new Login());
		return "adminLogin";
	}
	@RequestMapping(path="/validateAdmin")
	public String validateAdmin(@Valid @ModelAttribute("adminLogin") Login adminLogin, BindingResult result,Model model,RedirectAttributes redirectAttributes) {
		if(result.hasErrors())
			return "adminLogin";
		ApiResponse	apiResponse= restTemplate.postForEntity(URLs.checkAdmin, adminLogin,ApiResponse.class).getBody();
		if(apiResponse.isStatus()) {
			model.addAttribute("admin", true);
			UserDto[] userList=restTemplate.getForObject(URLs.getAllUsersByStatus,UserDto[].class,URLs.status);
			if(userList.length!=0) {
				redirectAttributes.addFlashAttribute("userList",userList);
				return "redirect:adminhome";
			}
			return "redirect:adminHome2";
			
		}
		else {
			model.addAttribute("msg",apiResponse.getMessage());
		
		}
		return "adminLogin";
	}

	@RequestMapping("adminhome")
	public String adminhome(@SessionAttribute("admin") boolean admin) {
		return "adminHome";
	}
	@RequestMapping("adminHome2")
	public String adminhome2(@SessionAttribute("admin") boolean admin) {
		return "adminHome2";
	}
	@RequestMapping("/logout")
	public String logout(SessionStatus status) {
		status.setComplete();
		return "redirect:login";
	}
	
}
