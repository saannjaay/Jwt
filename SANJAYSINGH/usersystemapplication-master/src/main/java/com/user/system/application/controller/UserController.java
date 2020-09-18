package com.user.system.application.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.user.system.application.model.User;
import com.user.system.application.services.UserServices;

@RestController
@RequestMapping("user")
public class UserController {
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	@Autowired
	private UserServices userServices;

	@GetMapping
	public List<User> getAllUser() {
		return userServices.getAllUser();
	}

	@GetMapping("/{id}")
	public User getuserById(@PathVariable(name = "id") int id) {
		return userServices.getUserById(id);
	}

	@PostMapping
	public User createUser(@RequestBody User user) {
		user.setId(0);
		return userServices.createUser(user);
	}

	@PutMapping("/{uid}")
	public User updateUser(@PathVariable(name = "uid") Integer uid, @RequestBody User user) {

		logger.info("User is updated ");
		return userServices.updateUser(uid, user);
	}

	@DeleteMapping("/{id}")
	public String deleteUser(@PathVariable(name = "id") Integer id) {
		logger.info("user is deleted" + id);
		userServices.deleteUser(id);
		return "User has been Deleted Id=" + " " + id;

	}
}
