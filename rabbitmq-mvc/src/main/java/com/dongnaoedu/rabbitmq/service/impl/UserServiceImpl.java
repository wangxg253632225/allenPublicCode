package com.dongnaoedu.rabbitmq.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dongnaoedu.rabbitmq.mapper.UserMapper;
import com.dongnaoedu.rabbitmq.model.User;
import com.dongnaoedu.rabbitmq.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {
 
	@Autowired
    UserMapper userMapper;
	
	public User getUser(String id) {
		return userMapper.selectUserByID(id);
	}
 
}
