package com.pos.service;

import java.util.List;

import com.pos.model.MenuMaster;
import com.pos.model.Taxes;
import com.pos.model.Establishment;
import com.pos.model.Floor;
import com.pos.model.L1menu;
import com.pos.model.L2menu;
import com.pos.model.L3menu;
import com.pos.model.MenuMaster;
import com.pos.model.Taxes;
import com.pos.model.Users;

public interface POSService {

	void addMenuMaster(MenuMaster menumaster);
	
	List<MenuMaster> findMenuMasters();
	
	void addTaxes(Taxes tax);
	
	List<Taxes> findTaxes();
	
	void addL1menu(L1menu l1menu);
	
	List<L1menu> findL1Menu();
	
	void addL2menu(L2menu l2menu);
	
	void addL3menu(L3menu l3menu);
	
	void addEstablishment(Establishment establishment);
	
	List<Establishment> findEstablishments();
	
	void addFloor(Floor floor);
	
	List<Floor> findFloors();
	
	void addUser(Users user);
	
	//populate dropdown	
	public List<L1menu> findByMM(int mmId);
	
	public List<L2menu> findByL1(int l1Id);
}
