package com.dongnaoedu.rabbitmq.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dongnaoedu.rabbitmq.model.User;
import com.dongnaoedu.rabbitmq.service.UserService;

@Controller
@RequestMapping(value = "user")
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
	@ResponseBody
	public User getUser(@PathVariable("id") String id) {
		User user = userService.getUser(id);
		return user;

	}

}
