package com.bankmanagement.services;

import java.util.List;

import com.bankmanagement.entities.Account;
import com.bankmanagement.entities.User;
import com.bankmanagement.payloads.ApiResponse;
import com.bankmanagement.payloads.Login;
import com.bankmanagement.payloads.UserDto;


public interface UserServices {

	List<UserDto> getAllUsers();
	UserDto getById(Integer id);
	UserDto createUser(UserDto userDto);
	UserDto updateUser(UserDto userDto,Integer id);
	UserDto updateUser(String status,Integer id);
	UserDto deleteUser(Integer id);
	User userDtoToUSer(UserDto userDto);
	UserDto userToUserDto(User user);
	boolean isExistPhoneNo(String phoneNo,Integer userId);
	boolean isExistPhoneNo(String phoneNo);
	boolean isExistEmail(String email,Integer userId);
	boolean isExistEmail(String email);
	ApiResponse userLoginCheck(Login userLogin);
	List<UserDto> getByStatus(String status);
	Account getAccountByUserId(Integer userId);
}
