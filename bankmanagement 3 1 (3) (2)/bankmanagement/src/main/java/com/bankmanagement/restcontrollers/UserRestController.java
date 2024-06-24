package com.bankmanagement.restcontrollers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bankmanagement.payloads.ApiResponse;
import com.bankmanagement.payloads.Login;
import com.bankmanagement.payloads.UserDto;
import com.bankmanagement.services.UserServices;

@RestController
@RequestMapping("/bankmanagement/user")
public class UserRestController {

	@Autowired
	UserServices userServices;
	@GetMapping("/")
	public ResponseEntity<List<UserDto>> getAllUsers(){
		return ResponseEntity.of(Optional.of(userServices.getAllUsers()));
	}
	@GetMapping("/{userId}")
	public ResponseEntity<UserDto> getById(@PathVariable Integer userId){
		return ResponseEntity.of(Optional.of(userServices.getById(userId)));
	}
	
	@PostMapping("/")
	public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto){
		
		return ResponseEntity.status(HttpStatus.CREATED).body(userServices.createUser(userDto));
	}
	@PutMapping("/{userId}")
	public ResponseEntity<?> updateUser(@RequestBody UserDto userDto ,@PathVariable Integer userId){
		return ResponseEntity.ok(userServices.updateUser(userDto, userId));
	}
	@DeleteMapping("/{userId}")
	public ResponseEntity<?> deleteUser(@PathVariable Integer userId){
		UserDto userDto= userServices.deleteUser(userId);
		return ResponseEntity.ok(userDto +"/n Deleted Successfully");
	}
	@PostMapping("/login")
	public ResponseEntity<ApiResponse> userLoginCheck(@RequestBody Login userLogin){
		
		ApiResponse apiResponse= userServices.userLoginCheck(userLogin);
			return new ResponseEntity<ApiResponse>(apiResponse,HttpStatus.ACCEPTED);

	}
	@GetMapping("/getbystatus/{status}")
	public ResponseEntity<List<UserDto>> getByStatus(@PathVariable String status){
		return ResponseEntity.status(HttpStatus.OK).body( userServices.getByStatus(status));
		
	}
	
}
