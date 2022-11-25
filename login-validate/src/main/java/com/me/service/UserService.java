package com.me.service;

import java.util.List;

import com.me.dto.UserDTO;
import com.me.entity.User;
import com.me.exceptions.UserNameAlreadyExistingException;
import com.me.exceptions.UserNotFoundException;

public interface UserService {

	User findByEmail(String email);

	User findByEmailAndPassword(String email, String password);

	public User userRegistration(User user) throws UserNameAlreadyExistingException;

	public List<User> viewAllUsers() throws UserNotFoundException;

	public User getUserByUsername(String username) throws UserNotFoundException;

	public User login(String userName, String password) throws UserNotFoundException;

}
