package com.bankmanagement.services;


import java.util.List;

import com.bankmanagement.entities.Payee;
import com.bankmanagement.entities.PayeeCompositeClass;
import com.bankmanagement.payloads.PayeeDto;
import com.bankmanagement.payloads.PayeeDto2;

public interface PayeeServices {

	Payee addPayee(PayeeDto payeeDto);
	Payee addPayee2(PayeeDto2 payeeDto2,Integer senderAccountNo);

	List<PayeeDto> getAllPayeeBySenderAccountNo(Integer senderAccountNo);
	List<PayeeDto> getAllOtherPayeeBySenderAccountNo(Integer senderAccountNo);
	
	Payee getByPayeeCompositeClass(PayeeCompositeClass payeeCompositeClass);
}
