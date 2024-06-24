package com.bankmanagement.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bankmanagement.entities.Account;
import com.bankmanagement.entities.Payee;
import com.bankmanagement.entities.PayeeCompositeClass;
import com.bankmanagement.exceptions.MyException;
import com.bankmanagement.payloads.PayeeDto;
import com.bankmanagement.payloads.PayeeDto2;
import com.bankmanagement.repositories.PayeeRepository;
import com.bankmanagement.services.AccountServices;
import com.bankmanagement.services.PayeeServices;

@Service
public class PayeeServicesImpl implements PayeeServices {

	@Autowired
	PayeeRepository payeeRepository;
	@Autowired
	AccountServices accountServices;
	@Override
	public List<PayeeDto> getAllPayeeBySenderAccountNo(Integer senderAccountNo) {
		// TODO Auto-generated method stub
		Account account=accountServices.getById(senderAccountNo);
		return payeeRepository.findAllByPayeeCompositeClassSenderAccountNo(account).stream().filter(obj->obj.getBranchId()==null).map(obj-> new PayeeDto(obj.getPayeeCompositeClass().getSenderAccountNo().getAccountNo(), obj.getPayeeCompositeClass().getRecieverAccountNo(),obj.getRecieverName())).collect(Collectors.toList());
	}
	@Override
	public Payee addPayee(PayeeDto payeeDto) {
		Payee payee=new Payee();
		PayeeCompositeClass payeeCompositeClass=new PayeeCompositeClass();
		Account account=accountServices.getById(payeeDto.getSenderAccountNo());
		payee.setRecieverName(accountServices.getById(payeeDto.getReceiverAccountNo()).getUser().getFirstName());
		payeeCompositeClass.setSenderAccountNo(account);
		payeeCompositeClass.setRecieverAccountNo(payeeDto.getReceiverAccountNo());
		payee.setPayeeCompositeClass(payeeCompositeClass);
		if(payeeRepository.findById(payeeCompositeClass).isEmpty())
			return payeeRepository.save(payee);
		
		throw new MyException("Payee Already Present");
	}
	@Override
	public Payee getByPayeeCompositeClass(PayeeCompositeClass payeeCompositeClass) {
		// TODO Auto-generated method stub
		return payeeRepository.findByPayeeCompositeClass(payeeCompositeClass).orElseThrow(()-> new MyException("Payee Not Found"));
	}
	
	@Override
	public Payee addPayee2(PayeeDto2 payeeDto2, Integer senderAccountNo) {
		
		Payee payee=new Payee();
		PayeeCompositeClass payeeCompositeClass=new PayeeCompositeClass();
		
		payeeCompositeClass.setSenderAccountNo(accountServices.getById(senderAccountNo));
		System.out.println(payeeDto2.getBranchName()+" "+payeeDto2.getBranchId());
		
		payeeCompositeClass.setRecieverAccountNo(payeeDto2.getReceiverAccountNo());
		payee=payeeRepository.findByPayeeCompositeClass(payeeCompositeClass).orElse(null);
		if(payee==null) {
			payee=new Payee();
			payee.setPayeeCompositeClass(payeeCompositeClass);
			payee.setRecieverName(payeeDto2.getReceiverName());
			payee.setBranchId(payeeDto2.getBranchId());
			return payeeRepository.save(payee);
		}
		if(payee.getBranchId()==null || !payee.getBranchId().equals(payeeDto2.getBranchId())) {
			payee.setRecieverName(payeeDto2.getReceiverName());
			payee.setBranchId(payeeDto2.getBranchId());
			return payeeRepository.save(payee);
		}
		
		throw new MyException("Payee already Exist");
	}
	@Override
	public List<PayeeDto> getAllOtherPayeeBySenderAccountNo(Integer senderAccountNo) {
		// TODO Auto-generated method stub
		
		return payeeRepository.findAllByPayeeCompositeClassSenderAccountNo(accountServices.getById(senderAccountNo)).stream().filter(obj->obj.getBranchId()!=null).map(obj-> new PayeeDto(obj.getPayeeCompositeClass().getSenderAccountNo().getAccountNo(), obj.getPayeeCompositeClass().getRecieverAccountNo(),obj.getRecieverName())).toList();
	}

}
