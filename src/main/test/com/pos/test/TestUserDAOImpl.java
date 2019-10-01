package com.pos.test;

import static org.junit.Assert.assertTrue;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.pos.configuration.AppConfig;
import com.pos.configuration.HibernateConfiguration;
import com.pos.dao.UserDAO;
import com.pos.model.Users;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class,HibernateConfiguration.class})
@WebAppConfiguration
public class TestUserDAOImpl {

	@Autowired
	UserDAO dao;

	@Test
	public void testAddUser() {
		
		dao.addUser(new Users("Testing", "Secret", "POS"));
		assertTrue(true);
		
		
	}

}
