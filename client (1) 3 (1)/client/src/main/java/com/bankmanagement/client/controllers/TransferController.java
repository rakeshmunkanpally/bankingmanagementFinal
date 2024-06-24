package com.bankmanagement.client.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bankmanagement.client.URLs;
import com.bankmanagement.client.payloads.ApiResponse;
import com.bankmanagement.client.payloads.Branch;
import com.bankmanagement.client.payloads.OtherBankTransfer;
import com.bankmanagement.client.payloads.PayeeDto;
import com.bankmanagement.client.payloads.PayeeDto2;
import com.bankmanagement.client.payloads.SameBankTransfer;
import com.bankmanagement.client.payloads.TransactionDetails;

import jakarta.validation.Valid;

@Controller
@SessionAttributes({"accountNo", "firstName","statementExecuted","otherBankTransfer","sameBankTransfer"})
@RequestMapping("/bankmanagement/client/user")
public class TransferController {

	@Autowired
	RestTemplate restTemplate;
	@RequestMapping("/transfer")
	public String sameBankTransfer(@SessionAttribute("accountNo") Integer accountNo,Model model) {
		model.addAttribute("statementExecuted",false);
		
		model.addAttribute("sameBankTransfer",new SameBankTransfer(accountNo, null,null));
		model.addAttribute("otherBankTransfer",new OtherBankTransfer(accountNo, null, null, null));
		return "fundTransfer";
	}
	@RequestMapping("/addPayee")
	public String addPayee(Model model) {
		model.addAttribute("payee",new PayeeDto());
		return "addPayee";
	}

	@RequestMapping("/createPayee")
	public String createPayee(@Valid @ModelAttribute("payee") PayeeDto payee,BindingResult result,@SessionAttribute("accountNo") Integer accountNo,RedirectAttributes redirectAttributes,Model model) {
		if(result.hasErrors()) {
			model.addAttribute("payee", payee);
			return "addPayee";
		}
		if(accountNo.equals(payee.getReceiverAccountNo())) {
			model.addAttribute("msg", "You Cannot Add Your Own Account");
			return "addPayee";
		}
		PayeeDto payeeDto=new PayeeDto(accountNo,payee.getReceiverAccountNo(),payee.getReceiverName());
		ApiResponse apiResponse=restTemplate.postForObject(URLs.addPayee, payeeDto, ApiResponse.class);
		redirectAttributes.addFlashAttribute("payeeList",restTemplate.getForObject(URLs.fundTransfer, PayeeDto[].class,accountNo));
		redirectAttributes.addFlashAttribute("msg", apiResponse.getMessage()+" payee added");
		return "redirect:transfer";
	}
	
	@RequestMapping("/transferAmount")
	public String transferAmount(@Valid @ModelAttribute("sameBankTransfer") SameBankTransfer sameBankTransfer,BindingResult result,@SessionAttribute("accountNo") Integer accountNo,Model model,RedirectAttributes redirectAttributes) {
		model.addAttribute("selectedBankOption", "same");
		model.addAttribute("otherBankTransfer",new OtherBankTransfer(accountNo, null, null, null));
		if(model.getAttribute("sameBankTransfer")==null) {
			model.addAttribute("sameBankTransfer",sameBankTransfer);
		}
		if(result.hasErrors()) {
			return "fundTransfer";
		}
		if(model.getAttribute("statementExecuted").equals(true)) {
			model.addAttribute("statementExecuted", false);
		}
		else {
			model.addAttribute("msg",restTemplate.postForObject(URLs.createFundTransfer, sameBankTransfer, ApiResponse.class).getMessage());
		}
		
		return "fundTransfer";
	}
	@RequestMapping("/transactions")
	public String getTransactions(@SessionAttribute("accountNo") Integer accountNo,Model model) {
		model.addAttribute("transactionList",restTemplate.getForEntity(URLs.getTransactionsByAccountNo, TransactionDetails[].class,accountNo).getBody());
		return "transaction";
	}
	@RequestMapping("/addPayee2")
	public String addPayee2(@SessionAttribute("accountNo") Integer accountNo,Model model) {
		model.addAttribute("branchList", restTemplate.getForObject(URLs.getAllOtherBranches, Branch[].class));
		model.addAttribute("payee2",new PayeeDto2(null, null, null, null));
		return "addPayee2";
	}
	@RequestMapping("/createPayee2")
	public String createPayee2(@Valid @ModelAttribute("payee2") PayeeDto2 payee2,BindingResult result,@SessionAttribute("accountNo") Integer accountNo, RedirectAttributes redirectAttributes,Model model) {
		if(result.hasErrors()) {
			model.addAttribute("payee2", payee2);
			return "addPayee2";
		}
		PayeeDto2 payeeDto=new PayeeDto2(payee2.getReceiverAccountNo(),payee2.getBranchId(),payee2.getBranchName(), payee2.getReceiverName());
		ApiResponse apiResponse=restTemplate.postForObject(URLs.addPayee2, payeeDto, ApiResponse.class,accountNo);
		redirectAttributes.addFlashAttribute("msg", apiResponse.getMessage()+" payee added");
		return "redirect:transfer";
	}
	@RequestMapping("/transferAmount2")
	public String transferAmount2(@Valid @ModelAttribute("otherBankTransfer") OtherBankTransfer otherBankTransfer,BindingResult result,@SessionAttribute("accountNo") Integer accountNo,Model model) {
		model.addAttribute("sameBankTransfer",new SameBankTransfer(accountNo, null,null));
		if(model.getAttribute("otherBankTransfer")==null) {
			model.addAttribute("otherBankTransfer",otherBankTransfer);
		}
		model.addAttribute("selectedBankOption", "other");
		if(result.hasErrors()) {
			return "fundTransfer";
		}
		if(model.getAttribute("statementExecuted").equals(true)) {
			model.addAttribute("statementExecuted", false);
		}
		else {
			
			model.addAttribute("msg",restTemplate.postForObject(URLs.createFundTransfer2, otherBankTransfer,ApiResponse.class).getMessage() );
		}
		return "fundTransfer";
	}
	
}
