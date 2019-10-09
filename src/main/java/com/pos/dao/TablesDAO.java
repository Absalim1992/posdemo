package com.pos.dao;

import java.util.List;

import com.pos.model.Floor;

import com.pos.model.Tables;

public interface TablesDAO {

	void addTables(Tables tables);
	
	public List<Floor> findByEst(int mmId);
}
