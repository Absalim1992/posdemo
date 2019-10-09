package com.pos.dao;

import java.util.List;

import com.pos.model.Floor;
import com.pos.model.L2menu;

public interface FloorDAO {
	
	void addFloor(Floor floor);
	

	
	List<Floor> findFloors();
}
