package com.pos.dao;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.pos.model.Tables;

@Repository("tablesdao")
public class TablesDAOImpl extends AbstractDao<Integer, Tables> implements TablesDAO{

	@Override
	public void addTables(Tables tables) {
		persist(tables);		
	}
	
}
