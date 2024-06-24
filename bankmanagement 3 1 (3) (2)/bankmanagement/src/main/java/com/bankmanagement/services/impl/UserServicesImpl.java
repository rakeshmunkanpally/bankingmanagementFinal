package com.bankmanagement.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.bankmanagement.entities.Account;
import com.bankmanagement.entities.User;
import com.bankmanagement.exceptions.MyException;
import com.bankmanagement.payloads.ApiResponse;
import com.bankmanagement.payloads.Login;
import com.bankmanagement.payloads.UserDto;
import com.bankmanagement.repositories.UserRepository;
import com.bankmanagement.services.AccountServices;
import com.bankmanagement.services.UserServices;

import jakarta.transaction.Transactional;

@Service
public class UserServicesImpl implements UserServices {

	@Autowired
	UserRepository userRepository;
	@Autowired
	ModelMapper modelMapper;
	@Autowired
	AccountServices accountServices;
	@Autowired
	PasswordEncoder passwordEncoder;

	@Override
	public List<UserDto> getAllUsers() {

		return userRepository.findAll().stream().map(user -> userToUserDto(user)).collect(Collectors.toList());
	}

	@Override
	public UserDto getById(Integer id) {
		User user = userRepository.findById(id).orElseThrow(() -> new MyException("User Not Found with Id : " + id));

		return userToUserDto(user);
	}

	@Override
	@Transactional
	public UserDto createUser(UserDto userDto) {

		if (userRepository.findById(userDto.getUserId()).isEmpty()) {
			if (isExistPhoneNo(userDto.getPhoneNo())) {
				throw new MyException("Phone No Already Exist");

			}
			if (isExistEmail(userDto.getEmail())) {
				throw new MyException("Email Already Exist");
			}
			User user = userDtoToUSer(userDto);
			user.setStatus("0");
			user.setPassword(passwordEncoder.encode(userDto.getPassword()));
			user = userRepository.save(user);
			return this.userToUserDto(user);
		} else {
			throw new MyException("User Id : " + userDto.getUserId() + " already exists");
		}
	}

	@Override
	@Transactional
	public UserDto updateUser(UserDto userDto, Integer id) {
		User user = userRepository.findById(id).orElseThrow(() -> new MyException("User Not Found with Id : " + id));
		user.setAddress(userDto.getAddress());

		if (!isExistPhoneNo(userDto.getPhoneNo(), id)) {
			user.setPhoneNo(userDto.getPhoneNo());
		} else {
			throw new  MyException("Phone No Already Exist");
		}

		if (!isExistEmail(userDto.getEmail(), id)) {
			user.setEmail(userDto.getEmail());
		} else {
			throw new MyException("Email Already Exist");
		}
		userRepository.save(user);
		return userToUserDto(user);
	}

	@Override
	@Transactional
	public UserDto deleteUser(Integer id) {
		User user = userRepository.findById(id).orElseThrow(() -> new MyException("User Not Found with Id : " + id));
		userRepository.delete(user);
		return userToUserDto(user);
	}

	@Override
	public User userDtoToUSer(UserDto userDTO) {

		return modelMapper.map(userDTO, User.class);
	}

	@Override
	public UserDto userToUserDto(User user) {
		return modelMapper.map(user, UserDto.class);
	}

	@Override
	public boolean isExistPhoneNo(String phoneNo, Integer userId) {
		User user = userRepository.findByPhoneNo(phoneNo);
		if (user == null)
			return false;
		else if (user.getUserId().equals(userId)) {
			return false;
		}
		return true;
	}

	@Override
	public boolean isExistEmail(String email, Integer userId) {
		User user = userRepository.findByEmail(email);
		if (user == null)
			return false;
		else if (user.getUserId().equals(userId)) {
			return false;
		}

		return true;
	}

	@Override
	public boolean isExistPhoneNo(String phoneNo) {
		User user = userRepository.findByPhoneNo(phoneNo);
		if (user == null)
			return false;

		return true;
	}

	@Override
	public boolean isExistEmail(String email) {
		User user = userRepository.findByEmail(email);
		if (user == null)
			return false;

		return true;
	}

	@Override
	public ApiResponse userLoginCheck(Login userLogin) {
		UserDto userDto= getById(userLogin.getId());
		if ( passwordEncoder.matches(userLogin.getPassword(), userDto.getPassword())) {
			if (userDto.getStatus().equals("0"))
				return new ApiResponse("Application is pending", false);
			else if (userDto.getStatus().equals("A")) {
				
				return new ApiResponse(userDto.getFirstName()+",", true);
			}
			else if (userDto.getStatus().equals("R"))
				return new ApiResponse("Application is Rejected", false);
		}
		return new ApiResponse("Invalid Credentials", false);
	}

	@Override
	public List<UserDto> getByStatus(String status) {
		// TODO Auto-generated method stub
		return userRepository.findAllByStatus(status).stream().map(user-> userToUserDto(user)).collect(Collectors.toList());
	}

	@Override
	public UserDto updateUser(String status, Integer id) {
		User user=userRepository.findById(id).orElseThrow(()-> new MyException("Couldn't get User"));
		user.setStatus(status);
		user=userRepository.save(user);
		
		return userToUserDto(user);
	}

	@Override
	public Account getAccountByUserId(Integer userId) {
		return accountServices.getAccountByUserId(userId);
	}

}
