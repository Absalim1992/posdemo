package com.pos.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import com.pos.model.Floor;

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
