package com.pos.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.mysql.fabric.xmlrpc.base.Array;
import com.pos.configuration.AppConfig;
import com.pos.configuration.HibernateConfiguration;
import com.pos.dao.MenuMasterDAO;
import com.pos.model.L1menu;
import com.pos.model.MenuMaster;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class,HibernateConfiguration.class})
@WebAppConfiguration
public class TestMenuMasterDAOImpl {

	@Autowired
	MenuMasterDAO dao;
	
	@Test
	@Ignore
	public void testAddMenuMaster() {
		MenuMaster mm = new MenuMaster("menuFeb2019");
		
		
		
		dao.addMenuMaster(mm);
		assertTrue(true);

	}
	
	@Test
	@Ignore
	public void testFindMenuMasters(){
		List<MenuMaster> menumasterList2 = dao.findMenuMasters();
		MenuMaster mm = menumasterList2.get(0);
		System.out.println(mm.getListL1Menu().get(0).getName());
		System.out.println(menumasterList2);
		assertTrue(true);
	}
	
	public MenuMaster getSampleMenuManter(){
		 
		MenuMaster menuMaster = new MenuMaster();
		menuMaster.setName("menujum2019");
		
		return menuMaster;
	}

}
