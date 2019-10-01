package com.pos.dao;

import org.springframework.stereotype.Repository;

import com.pos.model.Users;
@Repository("userdao")
public class UserDAOImpl extends AbstractDao<Integer, Users> implements UserDAO{

	@Override
	public void addUser(Users user) {
		persist(user);
		
	}

}
