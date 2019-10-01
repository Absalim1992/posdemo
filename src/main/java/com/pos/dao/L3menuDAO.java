package com.pos.dao;

import java.util.List;
import com.pos.model.L2menu;
import com.pos.model.L3menu;

public interface L3menuDAO {

public List<L2menu> findByL1(int l1Id);
	
	void addL3menu(L3menu l3menu);
}
