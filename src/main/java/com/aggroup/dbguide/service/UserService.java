package com.aggroup.dbguide.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aggroup.dbguide.bean.Post;
import com.aggroup.dbguide.bean.User;
import com.aggroup.dbguide.dao.UserDao;
import com.aggroup.dbguide.exception.NotFoundException;


@Service
public class UserService {
	
	@Autowired
	UserDao userDao;
	
	
	public List<User> findAll() {
		return userDao.findAll();
	}

	public User findById(Long id) {
		Optional<User> user= userDao.findById(id);
		if (!user.isPresent())
			throw new NotFoundException();
		return user.get();
	}
	
	public User saveUser(User user) {
		return userDao.save(user);
	}
	
	public void deleteUserById(Long id) {
		userDao.deleteById(id);
	}
	
	public List<Post> findPostsByUserId(Long id) {
		Optional<User> user= userDao.findById(id);
		if (!user.isPresent())
			throw new NotFoundException();
		return user.get().getPosts();
	}
}
