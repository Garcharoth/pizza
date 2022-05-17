package fr.epsi.rennes.poec.phiv.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.epsi.rennes.poec.phiv.domain.User;
import fr.epsi.rennes.poec.phiv.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/public/register")
	public void addUser(User user) {
		userService.addUser(user);
	}
}
