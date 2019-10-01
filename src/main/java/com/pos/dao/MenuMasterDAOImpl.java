package com.pos.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import com.pos.model.MenuMaster;

@Repository("menumasterdao")
public class MenuMasterDAOImpl extends AbstractDao<Integer, MenuMaster> implements MenuMasterDAO{

	@Override
	public void addMenuMaster(MenuMaster menumaster) {
		persist(menumaster);
		
	}

	@SuppressWarnings("unchecked")
	public List<MenuMaster> findMenuMasters() {
		Criteria criteria = createEntityCriteria();
		return (List<MenuMaster>) criteria.list();
	}

}
