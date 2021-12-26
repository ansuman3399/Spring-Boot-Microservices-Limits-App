package com.boot.rest.restwebservices.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.boot.rest.restwebservices.exception.UserNotFoundException;
import com.boot.rest.restwebservices.model.User;
import com.boot.rest.restwebservices.service.UserService;

@RestController
@RequestMapping("rest-web-service")
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(path = "/users/{id}", method = RequestMethod.GET)
	public User getuserById(@PathVariable int id) {
		User user = userService.findOne(id);
		if (user == null)
			throw new UserNotFoundException("user not found with id : " + id);
		/*
		 * EntityModel<User> model = EntityModel.of(user); WebMvcLinkBuilder linkToUsers
		 * = WebMvcLinkBuilder.linkTo((this.getClass()).findAllUsers());
		 * model.add(linkToUsers.withRel("all-users"));
		 */
		return user;
	}

	/*
	 * @RequestMapping(path = "/users", method = RequestMethod.POST) public User
	 * save(@Valid @RequestBody User user) { return userService.save(user); }
	 */

	@RequestMapping(path = "/users", method = RequestMethod.POST)
	public ResponseEntity<Object> saveUser(@Valid @RequestBody User user) {
		User savedUser = userService.save(user);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId())
				.toUri();
		return ResponseEntity.created(location).build();
//		return userService.save(user);
	}

	@RequestMapping(path = "/users", method = RequestMethod.GET)
	public List<User> findAllUsers() {
		return userService.findAll();
	}

	@RequestMapping(path = "/users/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> deleteUserById(@PathVariable int id) {
		User user = userService.deleteById(id);
		if (user == null)
			return new ResponseEntity<>(user, HttpStatus.BAD_REQUEST);
		return new ResponseEntity<>(user, HttpStatus.ACCEPTED);
	}
	
}
