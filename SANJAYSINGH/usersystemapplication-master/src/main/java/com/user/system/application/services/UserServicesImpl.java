package com.user.system.application.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.user.system.application.exception.UserNotFoundException;
import com.user.system.application.model.User;
import com.user.system.application.repository.UserRepository;

/**
 * @author sanjsingh
 *
 */
@Component
public class UserServicesImpl implements UserServices {
	@Autowired
	private UserRepository userRepo;

	@Override
	public User createUser(User user) {

		return userRepo.save(user);
	}

	@Override
	public User updateUser(int id, User user) {
		Optional<User> opuser = userRepo.findById(id);
		if (opuser.isPresent()) {
			User userUpdate = opuser.get();
			userUpdate.setUsername(user.getUsername());
			

			return userRepo.save(userUpdate);
		} else {
			throw new UserNotFoundException("Please Enter Correct id=" + user.getId());
		}

	}

	@Override
	public List<User> getAllUser() {

		return userRepo.findAll();
	}

	@Override
	public User getUserById(int userid) {
		Optional<User> user = userRepo.findById(userid);
		if (user.isPresent()) {
			return user.get();
		} else {
			throw new UserNotFoundException("Please Enter Correct id=" + userid);
		}

	}

	@Override
	public void deleteUser(int userid) {
		Optional<User> user = userRepo.findById(userid);
		if (user.isPresent()) {
			userRepo.deleteById(userid);
		} else {
			throw new UserNotFoundException(
					"Please Enter Correct id OR this id is NOT available in DataBase =" + userid);
		}

	}

	@Override
	public User saveAll(List<User> users) {

		return (User) userRepo.saveAll(users);
	}

}
