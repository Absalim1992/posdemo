package com.pos.dao;

import java.util.List;

import com.pos.model.MenuMaster;

public interface MenuMasterDAO {

	void addMenuMaster(MenuMaster menumaster);
	
	List<MenuMaster> findMenuMasters();
}
