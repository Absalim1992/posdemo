package com.pos.dao;

import java.util.List;

import com.pos.model.L1menu;
import com.pos.model.MenuMaster;

public interface L1MenuDAO {
	
	void addL1menu(L1menu l1menu);
	
	List<L1menu> findL1Menu();
	
	List<L1menu> findl1bymm(String mm);
}
