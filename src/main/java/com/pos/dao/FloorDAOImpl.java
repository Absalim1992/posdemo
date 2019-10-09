package com.pos.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pos.model.Establishment;
import com.pos.model.Floor;
import com.pos.model.L1menu;
import com.pos.model.L2menu;

@Repository("floordao")
public class FloorDAOImpl extends AbstractDao<Integer, Floor> implements FloorDAO{


	@Override
	public void addFloor(Floor floor) {
		persist(floor);		
	}

	@SuppressWarnings("unchecked")
	public List<Floor> findFloors() {
		Criteria criteria = createEntityCriteria();
		return (List<Floor>) criteria.list();
	}
	
	

}
