package com.me.controllerTest;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;



import com.fasterxml.jackson.databind.ObjectMapper;
import com.me.controller.UserController;
import com.me.entity.User;
import com.me.service.UserService;

@ExtendWith(MockitoExtension.class)
public class ControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@InjectMocks
	private UserController userController;
	
	@Mock
	private UserService userService;
	private User user;
	private List<User> users;
	
	@BeforeEach
	public void setUp() {
		
		user = new User();
		
    	user.setUsrId(2);
		user.setFirstName("Ilavarasi");
		user.setLastName("S");
		user.setEmail("ila@gmail.com");
		user.setContactNo("9807654321");
		user.setUserType("Admin");
		user.setPassword("ila123");
		
		mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
	}
	@Test
	public void testAddUser() throws Exception {
		
		when(userService.userRegistration(any())).thenReturn(user);
		mockMvc.perform(
				post("/user/registerUser").contentType(MediaType.APPLICATION_JSON).content(asJsonString(user)))
			    .andExpect(status().isOk());
	            verify(userService,times(1)).userRegistration(any());
	}
	

	@Test
	public void testGetAllUser() throws Exception {
		
		when(userService.viewAllUsers()).thenReturn(users);
		mockMvc.perform(get("/user/all").contentType(MediaType.APPLICATION_JSON)
				.content(asJsonString(users))).andDo(print());
		verify(userService, times(1)).viewAllUsers();
	}
	@Test
	public void testGetUserByEmailId() throws Exception {
		
		when(userService.findByEmail("ila@gmail.com")).thenReturn(user);
		mockMvc.perform(get("/user/view/username").contentType(MediaType.APPLICATION_JSON)
				.content(asJsonString(user))).andDo(print());
		userService.findByEmail("ila@gmail.com");
	}
	
	
	public static String asJsonString(final Object obj) {
		try {
			final ObjectMapper mapper = new ObjectMapper(); 
			final String jsonContent = mapper.writeValueAsString(obj);
			return jsonContent;
		}
		catch (Exception exception) {
			throw new RuntimeException(exception); 
		}
	}

	
}
