package com.pos.dao;

import java.util.List;

import com.pos.model.L1menu;
import com.pos.model.L2menu;

public interface L2MenuDAO {
	
	void addL2menu(L2menu l2menu);
	
	public List<L1menu> findByMM(int mmId);
	
	 
}
