package com.aggroup.dbguide.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aggroup.dbguide.bean.User;

@Repository
public interface UserDao extends JpaRepository<User, Long>{

}
