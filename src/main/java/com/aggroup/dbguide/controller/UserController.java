package com.aggroup.dbguide.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.aggroup.dbguide.bean.Post;
import com.aggroup.dbguide.bean.User;
import com.aggroup.dbguide.service.UserService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;


@RestController("/users")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@Operation(description = "Get all users")
    @ApiResponses(@ApiResponse(responseCode  = "1", description  = "Success"))
	
	@GetMapping(value = {"","/"}, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<User> findAll() {
		return userService.findAll();
	}
	
	@Operation(description = "Get user by id")
    @ApiResponses({@ApiResponse(responseCode = "1", description = "Success"),
    				@ApiResponse(responseCode  = "3", description  = "Not Found")})
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = {MediaType.ALL_VALUE})
	public User findById(@PathVariable Long id) {
		return userService.findById(id);
	}
	
	@Operation(description = "Get user posts by user id")
    @ApiResponses({@ApiResponse(responseCode = "1", description = "Success"),
    				@ApiResponse(responseCode  = "3", description  = "Not Found")})
	@GetMapping(value = "/{id}/posts", produces = MediaType.APPLICATION_JSON_VALUE, consumes = {MediaType.ALL_VALUE})
	public List<Post> findPostsByUserId(@PathVariable Long id) {
		return userService.findPostsByUserId(id);
	}

}
