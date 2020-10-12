package com.aggroup.dbguide.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aggroup.dbguide.bean.Post;

@Repository
public interface PostDao extends JpaRepository<Post, Long>{

}
