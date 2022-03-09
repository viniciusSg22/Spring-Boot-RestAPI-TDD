package com.vsanches.tddrestapi;

package com.vsanches.tddrestapi;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.vsanches.tddrestapi.dto.UserDTO;
import com.vsanches.tddrestapi.entities.User;
import com.vsanches.tddrestapi.repositories.UserRepository;
import com.vsanches.tddrestapi.services.UserService;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

	@Mock
	private UserRepository userRepository;

	@InjectMocks
	private UserService userService;

	@Test
	void ShouldReturnAllUsers() {
		List<User> userList = new ArrayList<>();
		userList.add(new User(1L, "Fulano", "fulaninho", "fulano@gmail.com", "12345678"));
		userList.add(new User(2L, "Ciclano", "ciclaninho", "ciclano@gmail.com", "87654321"));

		when(userRepository.findAll()).thenReturn(userList);

		List<UserDTO> expected = userService.findAllUsers();

		assertEquals(expected.size(), userList.size());
	}
}