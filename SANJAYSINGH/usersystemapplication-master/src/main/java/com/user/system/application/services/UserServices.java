package com.user.system.application.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.user.system.application.model.User;

/**
 * @author sanjsingh
 *
 */
@Service
@Transactional
public interface UserServices {
	public User createUser(User user);

	public User updateUser(int id, User user);

	public List<User> getAllUser();

	public User getUserById(int userid);

	public void deleteUser(int id);

	public User saveAll(List<User> users);
}
