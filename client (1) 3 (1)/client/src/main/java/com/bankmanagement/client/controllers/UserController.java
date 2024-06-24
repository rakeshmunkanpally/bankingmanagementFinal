package com.bankmanagement.client.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bankmanagement.client.URLs;
import com.bankmanagement.client.payloads.ApiResponse;
import com.bankmanagement.client.payloads.Login;
import com.bankmanagement.client.payloads.Transaction;
import com.bankmanagement.client.payloads.UserDto;
import com.bankmanagement.client.payloads.UserProfile;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
@SessionAttributes({"accountNo", "firstName","userId","user","status"})
@RequestMapping("/bankmanagement/client/user")
public class UserController {
	
	@Autowired
	RestTemplate restTemplate;
	@RequestMapping("/login")
	public String userLogin(Model model,SessionStatus sessionStatus) {
		
		sessionStatus.setComplete();
		model.addAttribute("userLogin", new Login());
		return "login";
	}
	@RequestMapping(path="/validateUserLogin")
	public String validateUserLogin(@Valid @ModelAttribute("userLogin") Login userLogin,BindingResult result,RedirectAttributes  redirectAttributes,Model model) {
		if(result.hasErrors()) {
			model.addAttribute("userLogin",userLogin);
			return "login";
		}
		ApiResponse apiResponse= restTemplate.postForEntity(URLs.checkUserCredentials,userLogin,ApiResponse.class).getBody();
		if(apiResponse.isStatus()) {
			model.addAttribute("firstName", apiResponse.getMessage());
			model.addAttribute("userId", userLogin.getId());
			Integer accountNo=restTemplate.getForObject(URLs.getAccountByUserId, Integer.class,userLogin.getId());
			model.addAttribute("accountNo",accountNo );
			return "redirect:userhome";
		}
			
		model.addAttribute("msg", apiResponse.getMessage());
		return "login";
	}
	@RequestMapping("/userhome")
	public String userHome(@SessionAttribute("userId") Integer userId,WebRequest request) {
		request.removeAttribute("user", WebRequest.SCOPE_SESSION);
		return "userHomePage";
	}
	@RequestMapping("/registration")
	public String userRegistration(Model model) {
		model.addAttribute("user", new UserDto());
		model.addAttribute("status",true);
		
		return "userRegistration";
	}
	@RequestMapping(path="/validRegistration")
	public String validRegistration(@Valid @ModelAttribute("user") UserDto user,BindingResult result,Model model) {
		
		if(user==null) {
			model.addAttribute("user",(UserDto) model.getAttribute("user"));
		}
		model.addAttribute("user",user);
		if(result.hasErrors()) {
			return "userRegistration";
			
		}
		if(model.getAttribute("status").equals(true)) {
			model.addAttribute("msg", "Submitted Form SuccessFully UserId : "+user.getUserId());
			user=restTemplate.postForEntity(URLs.createUser, user, UserDto.class).getBody();
		}
		if(model.getAttribute("msg")==null){
			model.addAttribute("msg", "Submitted Form SuccessFully UserId : "+user.getUserId());
			user=restTemplate.postForEntity(URLs.createUser, user, UserDto.class).getBody();
		}
		
			
		
		return "userRegistration";
	}
	@RequestMapping("/deposit")
	public String deposit(Model model,@SessionAttribute("accountNo") Integer accountNo) {
		model.addAttribute("deposit", new Transaction());
		return "deposit2";
	}
	
	@RequestMapping(path="/validatedeposit")
	public String validateDeposit(@Valid @ModelAttribute("deposit") Transaction deposit, BindingResult result,RedirectAttributes redirectAttributes,HttpSession session) {
		Integer accountNo=(Integer) session.getAttribute("accountNo");
		if(result.hasErrors())
			return "deposit2";
		double balance=restTemplate.postForObject(URLs.deposit,deposit,Double.class, accountNo);
		redirectAttributes.addFlashAttribute("msg", deposit.getAmount() + " Amount deposited. Total Balance :"+balance);
		
		return "redirect:deposit";
	}
	
	
	@RequestMapping("/withdraw")
	public String withdraw(Model model,@SessionAttribute("accountNo") Integer accountNo) {
		model.addAttribute("withdraw", new Transaction());
		return "withdraw";
	}
	
	@RequestMapping(path="/validatewithdraw")
	public String validateWithdraw(@Valid @ModelAttribute("withdraw") Transaction withdraw, BindingResult result,RedirectAttributes redirectAttributes,@SessionAttribute("accountNo") Integer accountNo) {
		if(result.hasErrors())
			return "withdraw";
		ApiResponse apiResponse=restTemplate.postForObject(URLs.withdraw,withdraw,ApiResponse.class, accountNo);
		if(apiResponse.isStatus())
			redirectAttributes.addFlashAttribute("msg", withdraw.getAmount() + " Amount Withdrawn. Total Balance :"+apiResponse.getMessage());
		
		return "redirect:withdraw";
	}
	
	@RequestMapping("/checkBalance")
	public String checkBalance(@SessionAttribute("accountNo") Integer accountNo,Model model) {
		
		model.addAttribute("balance", restTemplate.getForObject(URLs.getBalance, Double.class,accountNo));
		return "checkBalance";
	}
	
	@RequestMapping("/userprofile")
	public String userProfile(@SessionAttribute("accountNo") Integer accountNo,Model model) {
		model.addAttribute("userprofile", restTemplate.getForObject(URLs.getUserProfile, UserProfile.class,accountNo));
		return "userprofile";
	}
	@RequestMapping("/updateUser")
	public String updateUser(@SessionAttribute("userId") Integer userId,Model model) {
		model.addAttribute("status",true);
		model.addAttribute("user", restTemplate.getForObject(URLs.getUserById, UserDto.class,userId));
		return "updateUser";
	}
	@RequestMapping("/validateUserUpdate")
	public String validateUserUpdate(@Valid @ModelAttribute("user") UserDto dto,BindingResult bindingResult,Model model) {
		model.addAttribute("user",(UserDto)model.getAttribute("user"));
		System.out.println(bindingResult.getFieldErrors());
		if(bindingResult.hasErrors() && bindingResult.getFieldErrorCount()>0) {
			return "updateUser";
		}
			if(model.getAttribute("status").equals(false) &&model.getAttribute("msg")!=null) {
				System.out.println(model.getAttribute("msg"));
				
				return "updateUser";
			}
			if(model.getAttribute("msg")==null) {
				model.addAttribute("user", restTemplate.exchange(URLs.updateUser, HttpMethod.PUT, new HttpEntity<UserDto>(dto), UserDto.class, dto.getUserId()));
				
			}

		return "redirect:userprofile";
	}
	@RequestMapping("/logout")
	public String logout(SessionStatus status) {
		status.setComplete();
		return "redirect:login";
	}
	
}
