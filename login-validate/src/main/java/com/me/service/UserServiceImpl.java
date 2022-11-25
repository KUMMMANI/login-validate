package com.me.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.me.dto.UserDTO;
import com.me.entity.User;
import com.me.exceptions.AuthenticationFailedException;
import com.me.exceptions.UserNameAlreadyExistingException;
import com.me.exceptions.UserNotFoundException;
import com.me.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepo;

	public User save(User user) {
		return userRepo.save(user);
	}

	public User findByEmail(String email) {
		return userRepo.findByEmail(email);
	}

	@Override
	public User findByEmailAndPassword(String email, String password) {

		return userRepo.findByEmailAndPassword(email, password);
	}

	@Override
	public User userRegistration(User user) throws UserNameAlreadyExistingException {
		String message = null;
		User user1 = null;
		if (this.userRepo.existsByEmail(user.getEmail())) {
			throw new UserNameAlreadyExistingException("user with given username already exist");
		}
		return userRepo.save(user);

	}

	@Override
	public List<User> viewAllUsers() throws UserNotFoundException {

		List<User> user = userRepo.findAll();
		if (user == null) {
			throw new UserNotFoundException("User not found");
		} else

			return user;
	}
	
	@Override
	public User getUserByUsername(String username) throws UserNotFoundException {
		if (!userRepo.existsByEmail(username)) {
			throw new UserNotFoundException("user not found");
		}
		return userRepo.findByEmail(username);
	}

	@Override
	public User login(String userName, String password) throws UserNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

}
