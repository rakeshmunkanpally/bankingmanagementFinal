package com.bankmanagement.client.exceptions;

import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bankmanagement.client.payloads.ApiResponse;

import jakarta.servlet.http.HttpServletRequest;


@ControllerAdvice
@SessionAttributes({"statementExecuted","status"})
public class GlobalExceptionsHandler {

	@ExceptionHandler(HttpClientErrorException.class)
	public String httpClientExceptionHandler(HttpClientErrorException exception,HttpServletRequest request,Model model ,RedirectAttributes attributes ){
		attributes.addFlashAttribute("msg", exception.getResponseBodyAs(ApiResponse.class).getMessage());
		model.addAttribute("msg", exception.getResponseBodyAs(ApiResponse.class).getMessage());
		attributes.addFlashAttribute("status", exception.getResponseBodyAs(ApiResponse.class).isStatus());
		model.addAttribute("status",exception.getResponseBodyAs(ApiResponse.class).isStatus());
		System.out.println("E,"+exception.getResponseBodyAs(ApiResponse.class).isStatus());
		model.addAttribute("statementExecuted", true);
		attributes.addFlashAttribute("statementExecuted", true);
		String url=request.getRequestURI();
		url=url.substring(url.lastIndexOf("/")+1, url.length());
		return "redirect:"+url;
	}
	@ExceptionHandler(MyException.class)
	public String resourceNotFoundExceptionHandler(MyException exception,RedirectAttributes attributes,HttpServletRequest request){
		attributes.addFlashAttribute("msg", exception.getMessage());
		String url=request.getRequestURI();
		url=url.substring(url.lastIndexOf("/")+1, url.length());
		return "redirect:"+url;
	}
	
	@ExceptionHandler(ServletRequestBindingException.class)
	public String servletRequestBindingExceptionHandler(ServletRequestBindingException exception){
		return "redirect:/bankmanagement/client/home";
	}
	@ExceptionHandler(ResourceAccessException.class)
	public String resourceAccessExceptionHandler(ResourceAccessException exception){
		return "redirect:/bankmanagement/client/home";
	}

	
	
}
