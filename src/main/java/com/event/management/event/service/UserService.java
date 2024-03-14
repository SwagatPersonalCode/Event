package com.event.management.event.service;

import java.util.List;

import com.event.management.event.dto.request.UserDto;
import com.event.management.event.entity.User;

public interface UserService {

	boolean createUser(UserDto userDto);

	List<User> fetchAllUsers();

	User fetchUserDetailsBasedOnId(String userId);

	boolean updateUser(UserDto userDto);

	boolean deleteUser(String userId);

}
