package com.pos.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pos.model.Establishment;
import com.pos.model.Floor;
import com.pos.model.L1menu;
import com.pos.model.MenuMaster;
import com.pos.model.Tables;

@Repository("tablesdao")
public class TablesDAOImpl extends AbstractDao<Integer, Tables> implements TablesDAO{

	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void addTables(Tables tables) {
		persist(tables);		
	}
	
	@Override
	public List<Floor> findByEst(int eId) {
		System.out.println("Inside findByEst Function " + eId);
		List<Floor> floorlist = new ArrayList<Floor>();
		Session session = sessionFactory.openSession();
		
		try {
			System.out.println("In Try Block");
			//transaction = session.beginTransaction();
			
			Establishment e =  (Establishment) session.get(Establishment.class, eId);
			System.out.println("MenuMaster Details - " + e);
			
			List<Floor> states = e.getListFloor();
			for(Floor s : states)
			{		
				Floor se = new Floor(s.getId(), s.getName());
				floorlist.add(se);	
			}			
			//transaction.commit();
		}
		catch (Exception e) {
			floorlist = null;
			System.out.println("Exception Caught");
			System.out.println(e);
			
		}finally{
			session.close();
		}
		System.out.println(floorlist.size());
		return floorlist;
	}

}
