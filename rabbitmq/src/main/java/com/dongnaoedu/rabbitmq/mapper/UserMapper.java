package com.dongnaoedu.rabbitmq.mapper;

import com.dongnaoedu.rabbitmq.model.User;

public interface UserMapper {

	public User selectUserByID(String id);

}
