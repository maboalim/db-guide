package com.aggroup.dbguide.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.aggroup.dbguide.bean.Post;
import com.aggroup.dbguide.bean.User;
import com.aggroup.dbguide.service.PostService;
import com.aggroup.dbguide.service.UserService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
public class UserController {

	@Autowired
	UserService userService;

	@Autowired
	PostService postService;

	@Operation(description = "Get all users")
	@ApiResponses(@ApiResponse(responseCode = "200", description = "Success"))
	@GetMapping(value = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<User> findAll() {
		return userService.findAll();
	}

	@Operation(description = "Get user by id")
	@ApiResponses({ @ApiResponse(responseCode = "200", description = "Success"),
			@ApiResponse(responseCode = "404", description = "Not Found") })
	@GetMapping(value = "/users/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = { MediaType.ALL_VALUE })
	public User findById(@PathVariable Long id) {
		return userService.findById(id);
	}

	@Operation(description = "Save new user")
	@ApiResponses({ @ApiResponse(responseCode = "200", description = "Success") })
	@PostMapping(value = "/users", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> saveUser(@RequestBody User user) {
		User savedUser = userService.saveUser(user);
		return ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedUser.getId()).toUri()).build();
	}

	@Operation(description = "Delete user by Id")
	@ApiResponses({ @ApiResponse(responseCode = "200", description = "Success") })
	@PostMapping(value = "/users/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void deleteUser(@PathVariable Long id) {
		userService.deleteUserById(id);
	}

	@Operation(description = "Get user posts by user id")
	@ApiResponses({ @ApiResponse(responseCode = "200", description = "Success"),
			@ApiResponse(responseCode = "404", description = "Not Found") })
	@GetMapping(value = "/users/{id}/posts", produces = MediaType.APPLICATION_JSON_VALUE, consumes = {
			MediaType.ALL_VALUE })
	public List<Post> findPostsByUserId(@PathVariable Long id) {
		return userService.findPostsByUserId(id);
	}

	@Operation(description = "Save new post")
	@ApiResponses({ @ApiResponse(responseCode = "200", description = "Success") })
	@PostMapping(value = "/users/{id}/posts", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> savePost(@PathVariable("id") Long userId, @RequestBody Post post) {
		Post newPost = postService.savePost(post, userId);
		return ResponseEntity.created(
				ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newPost.getId()).toUri())
				.build();
	}

	@Operation(description = "Delete post by Id")
	@ApiResponses({ @ApiResponse(responseCode = "200", description = "Success") })
	@DeleteMapping(value = "/users/{id}/posts/{postId}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void deletePost(@PathVariable Long postId) {
		postService.deletePostById(postId);
	}

}
