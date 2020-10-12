package com.aggroup.dbguide.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aggroup.dbguide.bean.Post;
import com.aggroup.dbguide.bean.User;
import com.aggroup.dbguide.dao.PostDao;
import com.aggroup.dbguide.dao.UserDao;
import com.aggroup.dbguide.exception.NotFoundException;

@Service
public class PostService {

	@Autowired
	PostDao postDao;
	
	@Autowired
	UserDao userDao;
	
	public Post savePost(Post post, Long userId) {
		Optional<User> user= userDao.findById(userId);
		if (!user.isPresent())
			throw new NotFoundException();
		post.setUser(user.get());
		return postDao.save(post);
	}
	
	public void deletePostById(Long postId) {
		postDao.deleteById(postId);
	}
}
