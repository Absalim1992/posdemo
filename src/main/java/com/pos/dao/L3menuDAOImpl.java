package com.pos.dao;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pos.model.L1menu;
import com.pos.model.L2menu;
import com.pos.model.L3menu;

@Repository("l3menudao")
public class L3menuDAOImpl extends AbstractDao<Integer, L3menu> implements L3menuDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Override
	public List<L2menu> findByL1(int l1Id) {
		System.out.println("Inside FindByL1 Function " + l1Id);
		List<L2menu> l2menulist = new ArrayList<L2menu>();
		Session session = sessionFactory.openSession();
		
		try {
			System.out.println("In Try Block");
			//transaction = session.beginTransaction();
			
			L1menu m =  (L1menu) session.get(L1menu.class, l1Id);
			System.out.println("L1menu Details - " + m);
			
			List<L2menu> states = m.getListL2Menu();
			for(L2menu s : states)
			{		
				L2menu se = new L2menu(s.getId(), s.getName());
				l2menulist.add(se);	
				System.out.println(se);
			}			
			//transaction.commit();
		}
		catch (Exception e) {
			l2menulist = null;
			System.out.println("Exception Caught");
			System.out.println(e);
			
		}finally{
			session.close();
		}
		System.out.println("L2Menu List - "+l2menulist);
		return l2menulist;
	}

	@Override
	public void addL3menu(L3menu l3menu) {
		persist(l3menu);
	}

	
}
