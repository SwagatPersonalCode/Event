package com.event.management.event.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.event.management.event.dao.UserDao;
import com.event.management.event.dto.request.UserDto;
import com.event.management.event.entity.User;
import com.event.management.event.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	
    private UserDao userDao;

	@Autowired
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	@Override
	public boolean createUser(UserDto userDto) {
		User user = initializeUserEntity(userDto);
		User saved = userDao.save(user);
		if(saved != null)
			return true;
		return false;
	}

	private User initializeUserEntity(UserDto userDto) {
		User user = new User();
		BeanUtils.copyProperties(userDto,user);
		return user;
	}

	@Override
	public List<User> fetchAllUsers() {
		List<User> userList = userDao.findAll();
		return userList;
	}

	@Override
	public User fetchUserDetailsBasedOnId(String userId) {
		Optional<User> userDetails =  userDao.findById(Long.parseLong(userId));
		if(userDetails.isPresent())
			return userDetails.get();
		return null;
	}

	@Override
	public boolean updateUser(UserDto userDto) {
		if(userDto !=null) {
			User user = fetchUserDetailsBasedOnId(userDto.getUserId().toString());
			BeanUtils.copyProperties(userDto,user);
			userDao.save(user);
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteUser(String userId) {
		User user = fetchUserDetailsBasedOnId(userId);
		if(user != null) {
			 userDao.delete(user);
			 return true;
		}
		 
		return false;
	}

}
