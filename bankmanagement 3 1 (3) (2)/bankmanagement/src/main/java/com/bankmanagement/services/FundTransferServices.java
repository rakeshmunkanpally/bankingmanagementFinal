package com.bankmanagement.services;

import com.bankmanagement.entities.FundTransfer;
import com.bankmanagement.entities.Payee;
import com.bankmanagement.payloads.ApiResponse;
import com.bankmanagement.payloads.OtherBankTransfer;
import com.bankmanagement.payloads.SameBankTransfer;

public interface FundTransferServices {

	ApiResponse createFundTransfer(SameBankTransfer sameBankTransfer);
	ApiResponse createFundTransfer2(OtherBankTransfer otherBankTransfer);
	FundTransfer getByPayee(Payee payee);
}
