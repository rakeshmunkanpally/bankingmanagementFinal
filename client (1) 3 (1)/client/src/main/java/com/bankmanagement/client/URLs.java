package com.bankmanagement.client;



public class URLs {

	
	public static final String createUser="http://localhost:8080/bankmanagement/user/";
	public static final String updateUser="http://localhost:8080/bankmanagement/user/{userId}";
	public static final String deleteUser="http://localhost:8080/bankmanagement/user/{userId}";
	public static final String getUserById="http://localhost:8080/bankmanagement/user/{userId}";
	public static final String getAllUsers="http://localhost:8080/bankmanagement/user/";
	public static final String getAllUsersByStatus="http://localhost:8080/bankmanagement/user/getbystatus/{status}";
	public static final String checkUserCredentials="http://localhost:8080/bankmanagement/user/login";
	public static final String changeStatus="http://localhost:8080/bankmanagement/admin/userstatus";
	public static final String status="0";
	public static final String createAdmin="http://localhost:8080/bankmanagement/admin/";

	public static final String checkAdmin="http://localhost:8080/bankmanagement/admin/login";

	public static final String getAccountByUserId="http://localhost:8080/bankmanagement/account/{userId}";

	public static final String deposit="http://localhost:8080/bankmanagement/transaction/deposit/{accountNo}";
	public static final String withdraw="http://localhost:8080/bankmanagement/transaction/withdraw/{accountNo}";
	public static final String getBalance="http://localhost:8080/bankmanagement/transaction/{accountNo}";
	public static final String getUserProfile="http://localhost:8080/bankmanagement/transaction/userprofile/{accountNo}";
	
	public static final String getAllBranches="http://localhost:8080/bankmanagement/branch/";
	public static final String getAllOtherBranches="http://localhost:8080/bankmanagement/branch/other";
	
	
	public static final String getAccounts="http://localhost:8080/bankmanagement/account/getAccounts/{accountNo}";
	public static final String getTransactionsByAccountNo="http://localhost:8080/bankmanagement/account/transactions/{accountNo}";
	
	public static final String fundTransfer="http://localhost:8080/bankmanagement/fundtransfer/{senderAccountNo}";
	public static final String fundTransferOther="http://localhost:8080/bankmanagement/fundtransfer/otherBank/{senderAccountNo}";
	
	public static final String addPayee="http://localhost:8080/bankmanagement/fundtransfer/createPayee";
	public static final String addPayee2="http://localhost:8080/bankmanagement/fundtransfer/createPayee2/{senderAccountNo}";

	
	public static final String createFundTransfer="http://localhost:8080/bankmanagement/fundtransfer/createFundTransfer";
	public static final String createFundTransfer2="http://localhost:8080/bankmanagement/fundtransfer/createFundTransfer2";
}
