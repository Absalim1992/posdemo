package com.pos.test;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.pos.configuration.AppConfig;
import com.pos.configuration.HibernateConfiguration;
import com.pos.dao.L2MenuDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class,HibernateConfiguration.class})
@WebAppConfiguration
public class TestL1MenuDAOImpl {

	@Autowired
	L2MenuDAO dao;
	

	@Test
	@Ignore
	public void testAddL1Menu() {
		//dao.addL1menu(getL1Menu());
		//assertTrue(true);
	}
	
	@Test
	public void getL1Menu(){
		//L1menu l1menu = new L1menu();
		//l1menu.setName("Food");
		//assertEquals("Liquor", dao.findl1bymm("menuFeb2019").get(0).getName());
		assertTrue(dao.findByMM(3).size() > 0);
		assertEquals("Food",dao.findByMM(3).get(0).getName());
	}

}
