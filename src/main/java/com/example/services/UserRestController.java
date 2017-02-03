package com.example.services;

import java.security.Principal;
import java.util.Collection;
import java.util.LinkedList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
class UserRestController {

	private final UserRepository userRepository;

	@Autowired
	UserRestController(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@RequestMapping(method = RequestMethod.GET)
	public Principal user(Principal principal) {
		User current = userRepository.findByFacebookId(principal.getName());
		System.out.println(current);
		if(current == null){
			User newUser = new User(principal.getName());
			userRepository.save(newUser);
			System.out.println("Added new user: " + newUser.getUsername());
			current = newUser;
		}else{
			System.out.println("Found existing User: " + current.getUsername());
			System.out.println("User Bookmarks: " + current.getBookmarks().size());
		}
		return principal;
	}
}
