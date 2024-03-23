package com.event.management.event.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.event.management.event.dto.request.UserDto;
import com.event.management.event.dto.response.CommonResponse;
import com.event.management.event.entity.User;
import com.event.management.event.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	private UserService userService;
	
    @Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
    
    @PostMapping("/createUser")
    public ResponseEntity<CommonResponse> createUser(@RequestBody UserDto userDto) {
    	
    	if(userService.createUser(userDto))
    		return ResponseEntity.status(HttpStatus.OK).body(new CommonResponse("200","User created successfully."));
    	
	   return ResponseEntity.status(HttpStatus.OK).body(new CommonResponse("200","Unable to save user details"));
    }
    
    @GetMapping("/allUsers")
    public List<User> fetchAllUsers(){
		return userService.fetchAllUsers();
    }
    
    @GetMapping("/fetchUserDetails")
    public User fetchUserDetails(@RequestParam(name="userId") String userId){
		return userService.fetchUserDetailsBasedOnId(userId);	
    }
    
    @PutMapping("/updateUser")
    public ResponseEntity<CommonResponse> updateUser(@RequestBody UserDto userDto) {
    	
    	if(userService.updateUser(userDto))
    		return ResponseEntity.status(HttpStatus.OK).body(new CommonResponse("200","User updated successfully."));
    	
	   return ResponseEntity.status(HttpStatus.OK).body(new CommonResponse("200","Unable to update user details"));
    	
    }
    
    @DeleteMapping("/deleteUser")
    public ResponseEntity<CommonResponse> deleteUser(@RequestParam(name="userId") String userId){
    	if(userService.deleteUser(userId))
    		return ResponseEntity.status(HttpStatus.OK).body(new CommonResponse("200","User deleted successfully deleted."));
    	
	   return ResponseEntity.status(HttpStatus.OK).body(new CommonResponse("200","Unable to delete user details"));
    }
	
}
