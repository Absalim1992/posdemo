package com.pos.dao;

import java.util.List;

import com.pos.model.Floor;

public interface FloorDAO {
	
	void addFloor(Floor floor);
	
	List<Floor> findFloors();
}
