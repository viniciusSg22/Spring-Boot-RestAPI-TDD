package com.vsanches.tddrestapi;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import com.vsanches.tddrestapi.controllers.UserController;
import com.vsanches.tddrestapi.dto.UserDTO;
import com.vsanches.tddrestapi.services.UserService;

@WebMvcTest(controllers = UserController.class)
@ExtendWith(SpringExtension.class)
public class UserControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private UserService userService;

	@Test
	void ShouldGetAllUsers() throws Exception {
		List<UserDTO> users = new ArrayList<>();
		users.add(new UserDTO(1L, "Fulano", "fulaninho", "fulano@gmail.com", "12345678"));
		users.add(new UserDTO(2L, "Beltrano", "beltraninho", "beltrano@gmail.com", "87654321"));

		when(userService.findAllUsers()).thenReturn(users);

		mockMvc.perform(get("/api/users")).andExpect(status().isOk()).andExpect(jsonPath("$.size()", is(users.size())));
	}

}
