package com.me.serviceTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.me.entity.User;
import com.me.repository.UserRepository;
import com.me.service.UserService;
import com.me.service.UserServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = UserServiceImplTest.class)
public class UserServiceImplTest {
	@Mock
	User user;

	@Mock
	UserRepository userRepository;

	@InjectMocks
	private UserService userService = new UserServiceImpl();
	
	@InjectMocks
	UserServiceImpl userServiceImpl;

	@Test
	void registerUserTest() {
		userServiceImpl.userRegistration(user);
		verify(userRepository, times(1)).save(any());
	}
	@Test
	void viewUserTest() {
		Mockito.when(userRepository.findById(any())).thenReturn(Optional.of(user));
		userServiceImpl.viewAllUsers();
	}
	

	@Test
	public void testGetAllUsers() {
		
		User user=new User();
		
		user.setUsrId(1);
		user.setFirstName("ila");
		user.setLastName("S");
		user.setEmail("ila@gmail.com");
		user.setContactNo("9809756432");
		user.setPassword("ila123");
		user.setUserType("admin");
		
		User user1=new User();
		user1.setUsrId(2);
		user1.setFirstName("ilava");
		user1.setLastName("S");
		user1.setEmail("ilava@gmail.com");
		user1.setContactNo("9809826432");
		user1.setPassword("ila1234");
		user1.setUserType("user");
		
		User user2=new User();
		user2.setUsrId(3);
		user2.setFirstName("indhu");
		user2.setLastName("i");
		user2.setEmail("indhu@gmail.com");
		user2.setContactNo("9509756432");
		user2.setPassword("indhu23");
		user2.setUserType("user");
		
		
		List<User> userList = new ArrayList<>();
		userList.add(user);
		userList.add(user1);
		userList.add(user2);
		
		when(userRepository.findAll()).thenReturn(userList);
		List<User> users = userService.viewAllUsers();
		assertEquals(3, users.size());
	}
}


