package com.pos.service;

import java.util.List;
import org.jboss.logging.annotations.Pos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.pos.dao.MenuMasterDAO;
import com.pos.dao.TablesDAO;
import com.pos.dao.TaxDAO;
import com.pos.model.MenuMaster;
import com.pos.model.Tables;
import com.pos.model.Taxes;
import com.pos.dao.EstablishmentDAO;
import com.pos.dao.FloorDAO;
import com.pos.dao.L1MenuDAO;
import com.pos.dao.L2MenuDAO;
import com.pos.dao.L3menuDAO;
import com.pos.dao.MenuMasterDAO;
import com.pos.dao.TaxDAO;
import com.pos.dao.UserDAO;
import com.pos.model.Establishment;
import com.pos.model.Floor;
import com.pos.model.L1menu;
import com.pos.model.L2menu;
import com.pos.model.L3menu;
import com.pos.model.MenuMaster;
import com.pos.model.Taxes;
import com.pos.model.Users;
@Service("posservice")
@Transactional
public class POSServiceImpl implements POSService{

	@Autowired
	private MenuMasterDAO mmdao;
	
	@Autowired
	private TablesDAO tablesdao;
	
	@Autowired
	private TaxDAO taxdao;
	
	@Autowired
	private L1MenuDAO l1menudao;
	
	@Autowired
	private L2MenuDAO l2menudao;
	
	@Autowired
	private L3menuDAO l3menudao;
	
	@Autowired
	private EstablishmentDAO establishmentdao;
	
	@Autowired
	private FloorDAO floordao;
	
	@Autowired
	private UserDAO userdao;
	
	@Override
	public void addMenuMaster(MenuMaster menumaster) {
		mmdao.addMenuMaster(menumaster);
		
	}

	@Override
	public List<MenuMaster> findMenuMasters() {
		
		return mmdao.findMenuMasters();
	}

	@Override
	public void addTaxes(Taxes tax) {
		taxdao.addTaxes(tax);
		
	}

	@Override
	public List<Taxes> findTaxes() {
		return taxdao.findTaxes();
	}

	@Override
	public void addL1menu(L1menu l1menu) {
		l1menudao.addL1menu(l1menu);
		
	}

	@Override
	public List<L1menu> findL1Menu() {
		return l1menudao.findL1Menu();
	}

	@Override
	public void addUser(Users user) {
		userdao.addUser(user);
		
	}

	@Override
	public void addL2menu(L2menu l2menu) {
		l2menudao.addL2menu(l2menu);
		
	}

	@Override
	public void addEstablishment(Establishment establishment) {
		establishmentdao.addEstablishment(establishment);
		
	}

	@Override
	public List<Establishment> findEstablishments() {
		return establishmentdao.findEstablishments();
	}

	@Override
	public void addFloor(Floor floor) {
		floordao.addFloor(floor);
		
	}

	@Override
	public List<Floor> findFloors() {
		return floordao.findFloors();
	}

	@Override
	public List<L1menu> findByMM(int mmId) {
		return l2menudao.findByMM(mmId);
	}

	@Override
	public List<L2menu> findByL1(int l1Id) {
		return l3menudao.findByL1(l1Id);
	}
	
	@Override
	public List<Floor> findByEst(int eId) {
		return tablesdao.findByEst(eId);
	}

	@Override
	public void addL3menu(L3menu l3menu) {
		l3menudao.addL3menu(l3menu);
	}

	@Override
	public void addTables(Tables tables) {
		tablesdao.addTables(tables);
	}


}
