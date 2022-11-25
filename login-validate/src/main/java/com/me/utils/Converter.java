package com.me.utils;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.me.dto.UserDTO;
import com.me.entity.User;

@Component
public class Converter {

	//userDto to userEntity
	public User convertToUserEntity(UserDTO userDTO) {
		User user=new User();
		
		BeanUtils.copyProperties(userDTO, user);
		
		System.out.println(user);
		return user;
	}
	
	//customerEntity to customerDto
	public UserDTO convertToUserDTO(User user) {
		UserDTO userDTO=new UserDTO();
		
		BeanUtils.copyProperties(user, userDTO);
		
		return userDTO;
	}
	
}
