package com.vsanches.tddrestapi;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import com.vsanches.tddrestapi.controllers.UserController;

@WebMvcTest(controllers = UserController.class)
@ExtendWith(SpringExtension.class)
public class UserControllerTeste {

	@Autowired
	private MockMvc mockMvc;

	@Test
	void ShouldGetAllUsers() throws Exception {
		mockMvc.perform(get("/api/users")).andExpect(status().isOk());
	}

}
